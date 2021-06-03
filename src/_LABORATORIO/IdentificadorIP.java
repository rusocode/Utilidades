package _LABORATORIO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

/* En este caso, el "oyente" o "listener" de las acciones producidas en los componentes, va a ser el JFrame (this). 
 * Por eso se implementa la interfaz ActionListener en la definicion de la clase IdentificadorIP, 
 * para escuchar todos los eventos producidos por la ventana (this). */
public class IdentificadorIP extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel panelURL;
	private JPanel panelDatos;
	private JLabel lblHost;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lblDominio;
	private JLabel lblIP;
	private JLabel lblPort;
	private JTextField txtHost;
	private JButton btnScan;

	private InetAddress address;
	private InetSocketAddress target;

	private static IdentificadorIP instance = null;
	private JSpinner spnPort;
	private JPanel panelOpciones;
	private JTextField txtURL;
	private JLabel lblURL;
	private JButton btnScan_1;
	private JButton button;

	public static void main(String[] args) {
		IdentificadorIP.getInstance().setVisible(true);
	}

	/* Patron SINGLETON: Sirve para crear un solo objeto de la clase y no varios objetos con el cual van a consumir recursos
	 * inecesarios del OS. */
	public static IdentificadorIP getInstance() {
		if (instance == null) instance = new IdentificadorIP();
		return instance;
	}

	private IdentificadorIP() {
		createGUI();
		setFrameProperties();
	}

	private void setFrameProperties() {
		setTitle("IP Scanner");
		setSize(373, 398);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void createGUI() {

		/* Panel URL */
		panelURL = new JPanel();
		panelURL.setBorder(new TitledBorder(null, "Seleccionar objetivo", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		lblHost = new JLabel("Host:");
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(panelURL, BorderLayout.NORTH);

		txtHost = new JTextField();
		txtHost.setToolTipText("Ingrese un hostname o una direccion IPS.");
		txtHost.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER && !txtHost.getText().isEmpty()) identificarIP();
			}

			@Override
			public void keyReleased(KeyEvent evt) {
				if (evt.getSource() == txtHost) habilitarBtn(txtHost, btnScan);
			}

			private void habilitarBtn(JTextField txtURL, JButton btnScan) {
				if (txtURL != null) {
					if (!txtURL.getText().isEmpty()) btnScan.setEnabled(true);
					else btnScan.setEnabled(false);
				}
			}
		});

		lblURL = new JLabel("URL:");

		txtURL = new JTextField();

		btnScan_1 = new JButton("Scan");

		button = new JButton("Scan");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout gl_panelURL = new GroupLayout(panelURL);
		gl_panelURL.setHorizontalGroup(gl_panelURL.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelURL.createSequentialGroup()
						.addGroup(gl_panelURL.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblURL, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
								.addComponent(lblHost, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
								.addComponent(txtHost, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE).addComponent(txtURL))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelURL.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnScan_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
						.addGap(43)));
		gl_panelURL.setVerticalGroup(gl_panelURL.createParallelGroup(Alignment.LEADING).addGroup(gl_panelURL.createSequentialGroup()
				.addComponent(lblHost, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panelURL.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtHost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(button))
				.addComponent(lblURL, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panelURL.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtURL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnScan_1))));
		panelURL.setLayout(gl_panelURL);

		panelOpciones = new JPanel();
		panelOpciones.setBorder(new TitledBorder(null, "Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelOpciones, BorderLayout.CENTER);

		lblPort = new JLabel("Port:");
		panelOpciones.add(lblPort);

		spnPort = new JSpinner();
		panelOpciones.add(spnPort);
		spnPort.setModel(new SpinnerNumberModel(new Integer(80), new Integer(1), null, new Integer(1)));

		btnScan = new JButton("Scan");
		panelOpciones.add(btnScan);
		btnScan.setFocusable(false);
		btnScan.setEnabled(false);
		// Agrega el "oyente" (this) a btnScan
		btnScan.addActionListener(this);
		panelDatos = new JPanel(null);
		panelDatos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Target info", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));

		lbl1 = new JLabel("Dominio:");

		lblDominio = new JLabel("-");

		lbl2 = new JLabel("IP:");

		lblIP = new JLabel("-");

		panelDatos.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelDatos.add(lbl1);
		panelDatos.add(lblDominio);
		panelDatos.add(lbl2);
		panelDatos.add(lblIP);
		getContentPane().add(panelDatos, BorderLayout.SOUTH);
		/* Panel Datos */

	}

	/* Se sobreescribe (@Override) el metodo actionPerformed(ActionEvent evt), ya que es un metodo de la interfaz
	 * ActionListener. */
	@Override
	public void actionPerformed(ActionEvent evt) {
		// Distingue el causante del evento
		if (evt.getSource() == btnScan) {
			// identificarIPSinPuerto();
			identificarIP();
		}

	}

	private void identificarIPSinPuerto() {
		try {

			/* InetAddress no tiene constructor. Una instancia de un InetAddress consta de una dirección IP y posiblemente su
			 * nombre de host correspondiente.
			 * 
			 * InetSocketAddress Esta clase implementa una dirección de socket IP (dirección IP + número de puerto). También
			 * puede ser un par (nombre de host + número de puerto), en cuyo caso se intentará resolver el nombre de host. */

			// Obtiene el nombre del host
			address = InetAddress.getByName(txtHost.getText());

			System.out.println(address);

			/* Host */
			lblDominio.setText(address.getHostName()); // Devuelve el dominio (DNS (sistema de nombres de dominio)/Nombre/Hostname) del host
														// especificado
			lblIP.setText(address.getHostAddress()); // Devuelve la IP del host especificado

			// InetSocketAddress a = new InetSocketAddress(host, puerto);
			// this.targetLabel.setText(a.getAddress().getHostAddress());

		} catch (UnknownHostException e) { // Si el host no existe, toma la excepcion
			e.printStackTrace();
		}

	}

	private void identificarIP() {
		setTarget(this.txtHost.getText());
	}

	private void setTarget(String target) {
		try {
			InetSocketAddress address = new InetSocketAddress(target, this.getPort());
			setSelectedTarget(address);
		} catch (Exception e) {
			error("Enter a valid host name or ip!");
		}
	}

	private void error(String message) {
		JOptionPane.showMessageDialog(this, message, "Error", 0);
	}

	private void setSelectedTarget(InetSocketAddress address) {
		if (address != null) {
			this.lblIP.setText(address.getAddress().getHostAddress());
			this.lblDominio.setText(address.getHostName());
		} else this.lblIP.setText("NONE!");

	}

	public int getPort() {
		return ((Integer) this.spnPort.getValue()).intValue();
	}

	private void identificarMAC() {

		NetworkInterface network;
		byte[] mac = null;

		try {
			network = NetworkInterface.getByInetAddress(address);
			mac = network.getHardwareAddress();
		} catch (SocketException e) {
			e.printStackTrace();
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
		}

		String MAC = sb.toString();

		// lblMAC.setText(MAC);
	}
}
