package pizzeria.clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import pizzeria.modelo.Mecanica;

public class Software extends JFrame {

	private static final long serialVersionUID = 1L;

	// Pizzas
	private String[] pizza = { "Mozzarella", "Mozzarella con morrones", "Mozzarella con provenzal", "Mozzarella con huevo", "Especial",
			"Especial con huevo", "Napolitana", "Napolitana especial", "Tomate y huevo", "Fugazza(sin mozzarella)", "Fugazzeta(sin salsa de tomate)",
			"Fugazzeta especial", "Fugazzeta con roquefort", "Roquefort", "4 quesos", "Anchoas", "Especial con anchoas", "Roquefort con anchoas",
			"Calabresa", "Palmitos", "Palmitos con jamon", "Tropical" };
	private short[] precioPizza = { 70, 80, 80, 80, 100, 100, 90, 100, 90, 70, 80, 90, 130, 120, 120, 120, 130, 130, 130, 120, 120, 130 };

	// Empanadas
	private String[] empanada = { "Arabes", "Criollas", "Jamon y queso" };
	private short[] precioEmpanada = { 9, 8, 9 };

	// Bebidas
	private String[] bebida = { "Gaseosas 350cc", "Gaseosas 1,25cc", "Cerveza cordoba", "Cerveza budweiser", "Cerveza heineken",
			"Agua saborizada 500cc", "Agua mineral 500cc", "Fernet medida+coca 350cc", "Gancia medida+sprite 350cc" };
	private short[] precioBebida = { 30, 40, 40, 50, 60, 20, 20, 60, 60 };

	// Componentes visuales del paquete swing
	private JLabel lblPizzas;
	private JLabel lblEmpanadas;
	private JLabel lblBebidas;
	private JLabel lblTotalLabel;
	private JLabel lblTotal;
	private JTextField txtCantidadPizzas;
	private JTextField txtCantidadEmpanadas;
	private JTextField txtCantidadBebidas;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnEliminarTodo;
	private JToggleButton tbtnMedia;
	private JComboBox<String> cbPizzas;
	private JComboBox<String> cbEmpanadas;
	private JComboBox<String> cbBebidas;

	// Tabla, modelo y barra
	private JTable tabla;
	private DefaultTableModel modelo;
	private JScrollPane scroll;

	// Identificadores de columnas
	private final static byte CODIGO_PIZZA = 1;
	private final static byte CODIGO_EMPANADA = 2;
	private final static byte CODIGO_BEBIDA = 3;

	private final static byte AUMENTO_MEDIA_PIZZA = 5;
	private final static byte LIMITE_CARACTERES = 3;

	// Cabecera de la tabla
	private int cantidad;
	private int precioUnitario;
	private int subTotal;
	private int total = 0;

	private TableColumn Tcol;
	private JCheckBoxHeader chkheader;
	private JCheckBox cb;

	public Software() {
		setFrameProperties();
		makeGUI();
	}

	private void setFrameProperties() {
		setTitle("Pizzeria");
		// setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Pizza.png")).getImage());
		getContentPane().setLayout(null);
		setSize(558, 405);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void makeGUI() {

		crearTabla();

		// PIZZAS
		lblPizzas = new JLabel("Pizzas:");
		lblPizzas.setBounds(10, 27, 33, 14);
		add(lblPizzas);

		cbPizzas = new JComboBox<>(pizza);
		cbPizzas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbPizzas.setBounds(82, 24, 186, 20);
		cbPizzas.setSelectedIndex(-1);
		cbPizzas.setFocusable(false);
		cbPizzas.addActionListener(new OyenteAccion());
		add(cbPizzas);

		txtCantidadPizzas = new JTextField();
		txtCantidadPizzas.setBounds(294, 24, 38, 20);
		txtCantidadPizzas.setEnabled(false);
		txtCantidadPizzas.addKeyListener(new OyenteTeclado());
		add(txtCantidadPizzas);

		tbtnMedia = new JToggleButton("MEDIA");
		tbtnMedia.setBounds(342, 23, 65, 23);
		tbtnMedia.setFocusable(false);
		tbtnMedia.setEnabled(false);
		add(tbtnMedia);
		// FIN

		// EMPANADAS
		lblEmpanadas = new JLabel("Empanadas:");
		lblEmpanadas.setBounds(10, 58, 59, 14);
		add(lblEmpanadas);

		cbEmpanadas = new JComboBox<>(empanada);
		cbEmpanadas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbEmpanadas.setBounds(82, 55, 186, 20);
		cbEmpanadas.setSelectedIndex(-1);
		cbEmpanadas.setFocusable(false);
		cbEmpanadas.addActionListener(new OyenteAccion());
		add(cbEmpanadas);

		txtCantidadEmpanadas = new JTextField();
		txtCantidadEmpanadas.setBounds(294, 55, 38, 20);
		txtCantidadEmpanadas.setEnabled(false);
		txtCantidadEmpanadas.addKeyListener(new OyenteTeclado());
		add(txtCantidadEmpanadas);
		// FIN

		// BEBIDAS
		lblBebidas = new JLabel("Bebidas:");
		lblBebidas.setBounds(10, 89, 59, 14);
		add(lblBebidas);

		cbBebidas = new JComboBox<>(bebida);
		cbBebidas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbBebidas.setBounds(82, 86, 186, 20);
		cbBebidas.setSelectedIndex(-1);
		cbBebidas.setFocusable(false);
		cbBebidas.addActionListener(new OyenteAccion());
		add(cbBebidas);

		txtCantidadBebidas = new JTextField();
		txtCantidadBebidas.setBounds(294, 86, 38, 20);
		txtCantidadBebidas.setEnabled(false);
		txtCantidadBebidas.addKeyListener(new OyenteTeclado());
		add(txtCantidadBebidas);
		// FIN

		// btnModificar
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(10, 128, 89, 23);
		btnModificar.setFocusable(false);
		btnModificar.setEnabled(false);
		btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				modificarFila();
			}
		});
		add(btnModificar);

		// btnEliminar
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(109, 128, 89, 23);
		btnEliminar.setFocusable(false);
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				eliminarFila();
			}
		});
		add(btnEliminar);

		// btnEliminarTodo
		btnEliminarTodo = new JButton("Eliminar todo");
		btnEliminarTodo.setBounds(208, 128, 93, 23);
		btnEliminarTodo.setFocusable(false);
		btnEliminarTodo.setEnabled(false);
		btnEliminarTodo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				eliminarTodo();
			}
		});
		add(btnEliminarTodo);

		lblTotalLabel = new JLabel("TOTAL:");
		lblTotalLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTotalLabel.setBounds(391, 335, 47, 14);
		add(lblTotalLabel);

		// lblTotal
		lblTotal = new JLabel("0 $");
		lblTotal.setFont(new Font("Trebuchet MS", Font.PLAIN, 15)); // lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal.setBounds(443, 335, 89, 14);
		lblTotal.setForeground(new Color(0, 204, 51));
		add(lblTotal);

		// getAccessibleContext().setAccessibleDescription(""); // ?

	}

	private void crearTabla() {
		/**
		 * El DefaultTableModel es una clase que implementa TableModel que contiene todos los metodos necesarios para modificar
		 * datos en su interior, añadir filas o columnas y darle a cada columna el nombre que se desee.
		 */

		/* Al vector bidimencional de objetos no lo voy a inicializar ahora ya que los datos se ingresan despues final
		 * Object[][] datos = {}; */

		// Creo el modelo de la tabla solo con el encabezado, ya que por ahora no se le pasa ningun dato
		modelo = new DefaultTableModel(null, new String[] { "Codigo", "Producto", "Cantidad", "Precio unitario", "Subtotal" }) {

			private static final long serialVersionUID = 1L;

			// Sobreescribo el metodo de la clase DefaultTableModel para hacer que una celda del JTable sea editable o no
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				// Solo hacemos editable la columna 0
				if (columnIndex == 0) return true;
				return false;
			}
		};

		// Creo la tabla y le paso el modelo
		tabla = new JTable(modelo); // o tabla.setModel(modelo);
		// tabla.setIntercellSpacing(new Dimension(5, 3));
		// tabla.setBorder(new LineBorder(new Color(0, 0, 0)));
		// tabla.setGridColor(new Color(0, 0, 0));
		// le paso como argumento una nueva clase de tipo MiRender
		// tabla.setDefaultRenderer(Object.class, new MiRender());

		// CABEZAL DE LA PRIMERA COLUMNA
		Tcol = tabla.getColumnModel().getColumn(0);
		Tcol.setCellEditor(tabla.getDefaultEditor(Boolean.class));
		Tcol.setCellRenderer(tabla.getDefaultRenderer(Boolean.class));
		chkheader = new JCheckBoxHeader(tabla);
		Tcol.setHeaderRenderer(chkheader);

		// Creo un JCheckBox para la columna 0
		tabla.getColumnModel().getColumn(0).setCellEditor(new Celda_CheckBox());
		// Pinta la columna con el JCheckBox en la tabla
		tabla.getColumnModel().getColumn(0).setCellRenderer(new Render_CheckBox());

		// tabla.getColumn("Codigo").setCellEditor(new Celda_CheckBox());
		// tabla.getColumn("Codigo").setCellRenderer(new Render_CheckBox());

		// Fija las columnas
		fijarColumnas(tabla);
		// Marca la fila seleccionada
		// tabla.setRowSelectionAllowed(true);
		// Permite solo la seleccion de una fila
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Quita el focus de la celda
		tabla.setFocusable(false);
		// Ancho de fila
		tabla.setRowHeight(20);
		// Cabecera de la tabla
		JTableHeader cabecera = tabla.getTableHeader();
		// cabezera.setPreferredSize(new Dimension(18, 18));
		// cabezera.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		cabecera.setOpaque(false);

		// Esta linea resume la clase MiRender
		tabla.setSelectionBackground(new Color(102, 153, 255));

		// DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		// tcr.setHorizontalAlignment(SwingConstants.CENTER);
		// tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);

		// Le paso un color a la cuadricula(lineas) de la tabla

		// Una vez creada la tabla con su modelo podemos agregar columnas y filas
		String[] newColumn = { "Flan", "Pastel", "Helado", "Barquillo", "Manzana" };
		// modelo.addColumn("Postre", newColumn);
		Object[] newRow = { "Pepe", "Grillo", "Tenis", new Integer(5), new Boolean(false), "Pera" };
		// modelo.addRow(newRow);

		// creamos un JScrollPane y le pasamos la tabla
		scroll = new JScrollPane(tabla);
		// le pasamos la posicion x e y ; ancho e alto, y luego lo agregamos al contenedor de la ventana
		scroll.setBounds(10, 162, 527, 162);
		getContentPane().add(scroll);

	}

	private void verificarIgualdadDeProductos(Object[] datos, JComboBox<String> combo) {
		// o tabla ?
		int cantidadFilas = modelo.getRowCount(); // tomo la cantidad de filas
		boolean existe = false; // para identificar si el producto existe en la tabla
		int fila = -1; // para tomar la fila del producto existente
		final int COLUMNA_PRODCUTO = 1;
		final int COLUMNA_CANTIDAD = 2;
		final int COLUMNA_SUBTOTAL = 4;

		// Si hay filas, entonces...
		if (cantidadFilas > 0) {
			for (int f = 0; f < cantidadFilas; f++) { // Itera cada fila de la tabla
				String producto = (String) modelo.getValueAt(f, COLUMNA_PRODCUTO); // Almacena el valor de la celda ubicada en la fila f y columna
																					// "Producto"
				if (combo.getSelectedItem().toString().equals(producto)) { // Si el item seleccionado del JComboBox es igual al producto de la fila f
																			// y columna producto
					System.out.println(combo.getSelectedItem() + " ya existe en la tabla."); // mensaje
					existe = true; // cambio a true, es decir que existe
					fila = f; // guardo la fila del producto existente
					break; // rompo la instruccion for para que no itere hasta el limite de filas
				} // fin de if anidado
			} // fin de for

			// si el item seleccionado no existe en la tabla, entonces agrego una nueva fila y calculo el total
			if (existe == false) {
				modelo.addRow(datos);
				total += subTotal;
				actualizarTotal();
			} // fin de if anidado

			// si el item seleccionado existe en la tabla, entonces le paso la nueva cantidad y subTotal al producto existente
			if (existe == true) {
				// calculo la nueva cantidad y subTotal
				int nuevaCantidad = (int) modelo.getValueAt(fila, COLUMNA_CANTIDAD) + cantidad;
				int nuevoSubTotal = nuevaCantidad * precioUnitario;

				// le paso la nueva cantidad y subTotal
				modelo.setValueAt(nuevaCantidad, fila, COLUMNA_CANTIDAD);
				modelo.setValueAt(nuevoSubTotal, fila, COLUMNA_SUBTOTAL);

				total += subTotal;
				actualizarTotal();
			} // fin de if anidado
		} // fin de if

		// POR QUE ESTA LINEA VA ACA?
		// si todavia no se ingreso ninguna fila
		if (cantidadFilas == 0) {
			modelo.addRow(datos);
			total += subTotal;
			actualizarTotal();
		} // fin de if

		// producto2 = "[MEDIA] " + producto;

	} // fin del metodo comprobarIgualdad()

	private void actualizarTotal() {
		lblTotal.setText(String.valueOf(total) + " $");
	}

	private void fijarColumnas(JTable tabla) {
		final int ANCHO_CODIGO = 43; // 43
		final int ANCHO_PRODUCTO = 250; // 250
		final int ANCHO_CANTIDAD = 53; // 53
		final int ANCHO_PRECIO_UNITARIO = 80; // 80
		final int ANCHO_TOTAL = 101; // 100
		// en total sumo 527 pixeles, que es igual al ancho de la tabla

		// para que no se puedan mover las columnas
		tabla.getTableHeader().setReorderingAllowed(false);
		// para que no se pueda cambiar el tama�o de las columnas
		tabla.getTableHeader().setResizingAllowed(false);

		// CODIGO
		tabla.getColumnModel().getColumn(0).setMinWidth(ANCHO_CODIGO);
		tabla.getColumnModel().getColumn(0).setMaxWidth(ANCHO_CODIGO);

		// PRODUCTO
		tabla.getColumnModel().getColumn(1).setMinWidth(ANCHO_PRODUCTO);
		tabla.getColumnModel().getColumn(1).setMaxWidth(ANCHO_PRODUCTO);

		// CANTIDAD
		tabla.getColumnModel().getColumn(2).setMinWidth(ANCHO_CANTIDAD);
		tabla.getColumnModel().getColumn(2).setMaxWidth(ANCHO_CANTIDAD);

		// PRECIO UNITARIO
		tabla.getColumnModel().getColumn(3).setMinWidth(ANCHO_PRECIO_UNITARIO);
		tabla.getColumnModel().getColumn(3).setMaxWidth(ANCHO_PRECIO_UNITARIO);

		// TOTAL
		tabla.getColumnModel().getColumn(4).setMinWidth(ANCHO_TOTAL);
		tabla.getColumnModel().getColumn(4).setMaxWidth(ANCHO_TOTAL);
	}

	private void modificarFila() {
		// tomo el valor de la fila seleccionada
		int f = tabla.getSelectedRow(); // EN ESTE CASO ES NECESARIO USAR LA TABLA Y NO EL MODELO PARA TOMAR EL VALOR DE LA FILA
		// tomo el valor de la columna seleccionada
		int c = tabla.getSelectedColumn();

		// si la fila es mayor o igual a 0 y la columna es igual a 0
		if (f >= 0 && c == 0) {
			// creamos una variable de tipo Object en donde almacenamos la fila y la columna pasadas como argumento al metodo
			// getValueAt
			Object celda = modelo.getValueAt(f, c); // f:n y c:0

			// si celda es igual a 1
			if ((int) celda == CODIGO_PIZZA) {
				// creo un objeto que obtiene el valor del subtotal de la columna 4
				Object subTot = modelo.getValueAt(f, 4); // f:n y c:4 (valor de subtotal de la fila seleccionada)
				// se lo resto al total
				total -= (int) subTot; // convierto el objeto a entero
				// actualizo el total
				actualizarTotal();

				cbPizzas.setSelectedItem(modelo.getValueAt(f, 1)); // tomo el valor con la tabla o con el modelo ?? LAS DOS COSAS FUNCIONAN IGUAL
				txtCantidadPizzas.setText(modelo.getValueAt(f, 2).toString());
				txtCantidadPizzas.selectAll();
				modelo.removeRow(f);
			}

			/**
			 * Primero se toma el valor de la celda seleccionada(que en este caso, nosotros mismos tenemos que seleccionar la celda
			 * de la columna 0("Codigo") para que funcione, sino nos daria error). Segundo, una vez tomado el valor de la
			 * celda(Fila: n y Columna: 0 <-- OBLIGATORIO!) suponiendo que esa celda tenia el valor de Codigo "2" lo convertimos a
			 * entero ya que celda es un objeto, y por ultimo preguntamos si celda es igual a c2 = 2 o a c1 = 1.
			 */
			// si la celda seleccionada es igual a Codigo "2"(empanada)
			if ((int) celda == CODIGO_EMPANADA) { // (int) f:n;c:0 = 1 o 2
				Object subTot = modelo.getValueAt(f, 4);
				total -= (int) subTot;
				actualizarTotal();

				// el modelo de la tabla toma el valor de la fila y de la columna 1(EJ: "CRIOLLAS") y se lo establece a cbEmpanadas
				cbEmpanadas.setSelectedItem(modelo.getValueAt(f, 1));
				// lo mismo para txtCantidadEmpanadas que seria la columna 2(EJ: "2")
				txtCantidadEmpanadas.setText(modelo.getValueAt(f, 2).toString());
				// txtCantidadEmpandas.setText(String.valueOf(dtm.getValueAt(f, 2)));
				// selecciono txtCantidadEmpanadas
				txtCantidadEmpanadas.selectAll();
				// remuevo la fila seleccionada
				modelo.removeRow(f);
			}

			// si la celda seleccionada es igual a Codigo "3"(bebidas)
			if ((int) celda == CODIGO_BEBIDA) {
				Object subTot = modelo.getValueAt(f, 4);
				total -= (int) subTot;
				actualizarTotal();
				cbBebidas.setSelectedItem(modelo.getValueAt(f, 1));
				txtCantidadBebidas.selectAll();
				modelo.removeRow(f);
			}

		} else {
			JOptionPane.showMessageDialog(this, "Seleccione el CODIGO que desea modificar.");
		}

		// si no hay filas deshabilito los botones
		if (tabla.getRowCount() == 0) { // fijarse si hay otra forma
			Mecanica.deshabilitarBotones(btnModificar, btnEliminar, btnEliminarTodo);
		}
	}

	private void eliminarFila() {
		int f = tabla.getSelectedRow();
		// si hay una fila seleccionada
		if (f >= 0) {
			// primero tomo el valor de la celda antes de eliminarlo de la tabla(fila)
			Object celda = modelo.getValueAt(f, 4); // tomo el valor de la celda: fila seleccionada y columna 4(donde se encuentra el subtotal)
			total -= (int) celda;// convierto el objeto a entero y se lo resto al total
			// actualizo el total
			actualizarTotal();
			// una vez actualizado el total remuevo la fila de la tabla
			modelo.removeRow(f);

		} else {
			JOptionPane.showMessageDialog(this, "Seleccione la fila que desea eliminar.");
		}

		// si no hay filas deshabilito los botones
		if (tabla.getRowCount() == 0) Mecanica.deshabilitarBotones(btnModificar, btnEliminar, btnEliminarTodo);

	}

	private void eliminarTodo() {
		for (int i = tabla.getRowCount() - 1; i >= 0; i--) // o modelo ?
			modelo.removeRow(i);

		// si no hay filas deshabilito los botones
		if (tabla.getRowCount() == 0) {
			Mecanica.deshabilitarBotones(btnModificar, btnEliminar, btnEliminarTodo);
			total = 0;
			actualizarTotal();
		}
	}

	private class OyenteAccion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {
			if (evt.getSource() == cbPizzas) guardarPrecioPizzaSeleccionada();
			if (evt.getSource() == cbEmpanadas) guardarPrecioEmpanadaSeleccionada();
			if (evt.getSource() == cbBebidas) guardarPrecioBebidaSeleccionada();

		}

		private void guardarPrecioPizzaSeleccionada() {

			if (cbPizzas.getSelectedIndex() != -1) {
				tbtnMedia.setEnabled(true);
				for (int i = 0; i < precioPizza.length; i++) {
					if (cbPizzas.getSelectedItem().toString().equals(pizza[i])) {
						precioUnitario = precioPizza[i];
						break;
					}
				}

				// Antes del for y afuera del primer if genera un bug
				Mecanica.accion1(txtCantidadPizzas, txtCantidadEmpanadas, txtCantidadBebidas, cbEmpanadas, cbBebidas);
			}

		}

		private void guardarPrecioEmpanadaSeleccionada() {
			if (cbEmpanadas.getSelectedIndex() != -1) {
				tbtnMedia.setEnabled(false); // if (tbtnMedia.isEnabled()) tbtnMedia.setEnabled(false);
				for (int i = 0; i < precioEmpanada.length; i++) {
					if (cbEmpanadas.getSelectedItem().toString().equals(empanada[i])) {
						precioUnitario = precioEmpanada[i];
						break;
					}
				}
				Mecanica.accion1(txtCantidadEmpanadas, txtCantidadPizzas, txtCantidadBebidas, cbPizzas, cbBebidas);
			}
		}

		private void guardarPrecioBebidaSeleccionada() {
			if (cbBebidas.getSelectedIndex() != -1) {
				tbtnMedia.setEnabled(false);
				for (int i = 0; i < precioBebida.length; i++) {
					if (cbBebidas.getSelectedItem().toString().equals(bebida[i])) {
						precioUnitario = precioBebida[i];
						break;
					}
				}
				Mecanica.accion1(txtCantidadBebidas, txtCantidadPizzas, txtCantidadEmpanadas, cbPizzas, cbEmpanadas);
			}
		}

	}

	private class OyenteTeclado extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent evt) {

			if (evt.getSource() == txtCantidadPizzas) {

				if (verificarDatosDeEntrada(evt, txtCantidadPizzas)) {

					String pizza;
					boolean bandera = false;

					if (tbtnMedia.isSelected()) {

						// Crea e inicializa las variables locales para agregarlas al vector de objetos
						pizza = "(Media) " + cbPizzas.getSelectedItem().toString();
						cantidad = Integer.parseInt(txtCantidadPizzas.getText());
						subTotal = (precioUnitario / 2) + AUMENTO_MEDIA_PIZZA;

						bandera = true;

						tbtnMedia.setSelected(false);
						tbtnMedia.setEnabled(false);

					} else {
						pizza = cbPizzas.getSelectedItem().toString();
						cantidad = Integer.parseInt(txtCantidadPizzas.getText());
						subTotal = precioUnitario * cantidad;
						tbtnMedia.setEnabled(false);
					}

					int pu = bandera ? (precioUnitario / 2) + AUMENTO_MEDIA_PIZZA : precioUnitario;

					cb = new JCheckBox();

					// Crea el vector de objetos con los datos ingresados por teclado
					Object[] datos = { new Boolean(false), /* CODIGO_PIZZA, */ pizza, cantidad, pu, subTotal }; // Este vector es de tipo
																												// unidimensional ya que solo se
																												// ingresa una fila y n columnas

					verificarIgualdadDeProductos(datos, cbPizzas);

					Mecanica.habilitarBotones(btnModificar, btnEliminar, btnEliminarTodo);
					Mecanica.accion2(txtCantidadPizzas, cbPizzas);

				}
			}

			if (evt.getSource() == txtCantidadEmpanadas) {

				if (verificarDatosDeEntrada(evt, txtCantidadEmpanadas)) {

					String empanada = cbEmpanadas.getSelectedItem().toString();
					cantidad = Integer.parseInt(txtCantidadEmpanadas.getText());
					subTotal = precioUnitario * cantidad;

					cb = new JCheckBox();

					Object[] datos = { new Boolean(false), /* CODIGO_EMPANADA, */ empanada, cantidad, precioUnitario, subTotal };

					verificarIgualdadDeProductos(datos, cbEmpanadas);

					Mecanica.habilitarBotones(btnModificar, btnEliminar, btnEliminarTodo);
					Mecanica.accion2(txtCantidadEmpanadas, cbEmpanadas);

				}
			}

			if (evt.getSource() == txtCantidadBebidas) {

				if (verificarDatosDeEntrada(evt, txtCantidadBebidas)) {

					String bebida = cbBebidas.getSelectedItem().toString();
					cantidad = Integer.parseInt(txtCantidadBebidas.getText());
					subTotal = precioUnitario * cantidad;

					Object[] datos = { new Boolean(false), /* CODIGO_BEBIDA, */ bebida, cantidad, precioUnitario, subTotal };

					verificarIgualdadDeProductos(datos, cbBebidas);

					Mecanica.habilitarBotones(btnModificar, btnEliminar, btnEliminarTodo);
					Mecanica.accion2(txtCantidadBebidas, cbBebidas);

				}
			}

		}

		@Override
		public void keyTyped(KeyEvent evt) {

			char tecla = evt.getKeyChar();

			if (evt.getSource() == txtCantidadPizzas) soloNumeros(evt, tecla, txtCantidadPizzas);
			if (evt.getSource() == txtCantidadEmpanadas) soloNumeros(evt, tecla, txtCantidadEmpanadas);
			if (evt.getSource() == txtCantidadBebidas) soloNumeros(evt, tecla, txtCantidadBebidas);

		}

		private boolean verificarDatosDeEntrada(KeyEvent evt, JTextField txt) {
			/* Devuelve true si el codigo de la tecla presionada es igual a la tecla enter, si el txt no esta vacio y si el primer
			 * caracter del txt es distinto a 0. */
			return evt.getKeyCode() == KeyEvent.VK_ENTER && !txt.getText().isEmpty() && txt.getText().charAt(0) != '0';
		}

		private void soloNumeros(KeyEvent evt, char tecla, JTextField txt) {
			// Si la tecla es menor al caracter 0 o mayor a al caracter 9, o la longitud del campo de texto es igual al limite,
			// entonces...
			if ((tecla < '0' || tecla > '9') || txt.getText().length() == LIMITE_CARACTERES) {
				evt.consume();
				Toolkit.getDefaultToolkit().beep();
			}
		}

	}

}
