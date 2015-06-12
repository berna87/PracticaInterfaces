package ejercicio9;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;

public class PrediccionTemperaturas {

	private JFrame frmPrediccionTemperaturasProvincia;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrediccionTemperaturas window = new PrediccionTemperaturas();
					window.frmPrediccionTemperaturasProvincia.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrediccionTemperaturas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrediccionTemperaturasProvincia = new JFrame();
		frmPrediccionTemperaturasProvincia.setTitle("Prediccion Temperaturas provincia Jaen");
		frmPrediccionTemperaturasProvincia.setBounds(100, 100, 520, 412);
		frmPrediccionTemperaturasProvincia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblConexion = new JLabel("Conexion : ");
		
		JLabel lblLocalidad = new JLabel("Municipio");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frmPrediccionTemperaturasProvincia.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
							.addGap(10))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblConexion, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblLocalidad)
								.addContainerGap(277, Short.MAX_VALUE)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblLocalidad)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblConexion)))
					.addContainerGap())
		);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		LocalidadDaoImp locDao = new LocalidadDaoImp();
		List<String> localidades = locDao.getNombreLocalidades(); //cargo en memoria un listado de todas las localidades de mi base de datos
		JList list = new JList(new ListModelLocalidades(localidades));
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				//al pulsar sobre un objeto de la lista me devuelve el string con el nombre de la localidad, con este llamo al metodo que me devuelve la id
				int idLoc = locDao.getIdByNombre((String)list.getSelectedValue());	
				
				try {
					URL url = new URL("http://www.aemet.es/xml/municipios/localidad_"+idLoc+".xml"); //creo la url partiendo modificandola en funcion del id obtenido
					lblConexion.setText(""+url);
					lblLocalidad.setText((String)list.getSelectedValue());
					URLConnection urlConn = url.openConnection();
					
			        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); //convierto el stream obtenido en un objeto dom
			        DocumentBuilder domBuilder = domFactory.newDocumentBuilder();
			        Document doc = domBuilder.parse(urlConn.getInputStream());
			        
			        Node raiz = (Node) doc.getFirstChild();
			        Node prediccion = UtilsAemet.getPrediccion(raiz); //creo una clase auxiliar para acceder a los string que quiero obtener que son la temperatura maxima y minima de cada dia
			        List<Node> dias = UtilsAemet.getDias(prediccion);
			        
			        String [] fechas = generarFechas(); //metodo que genera un listado de cabeceras en funcion de la fecha actual
			        String [][] tmps = new String [5][3]; //creo un array bidimensional para guardar los 5 primeros dias con sus 2 temperaturas
			        
			        for (int i = 0; i < 5; i++) {
							tmps[i][0] = UtilsAemet.getMaxima(UtilsAemet.getTemp(dias.get(i))); 
							tmps[i][1] = UtilsAemet.getMinima(UtilsAemet.getTemp(dias.get(i)));
					}
			 
			        table.setModel(new TableModelTemperaturas(tmps,fechas));
			        
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
		
		scrollPane.setViewportView(list);
		frmPrediccionTemperaturasProvincia.getContentPane().setLayout(groupLayout);
	}
	
	private String [] generarFechas(){
		String [] array = new String [5];
		LocalDate fecha = LocalDate.now();
		for (int i = 0; i < 5; i++) {
			array[i] = "Dia: "+fecha.plusDays(i).getDayOfMonth();
		}
		return array;
	}
}
