package miglayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.miginfocom.swing.MigLayout;

public class PrototipoCalculadora extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panelAjustes, panelPJ, panelNPC, panelCalculadora;
	private JComboBox<String> cbNivel, cbNPC, cbGrupo;
	private JButton btnAcerca;
	private JButton btnActualizar;
	private JButton btnNuevo;

	public PrototipoCalculadora() {

		super("Prototipo");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initialize();
	}

	private void initialize() {

		MigLayout layout = new MigLayout();
		getContentPane().setLayout(layout);

		// AJUSTES
		panelAjustes = new JPanel();
		panelAjustes.setLayout(new MigLayout("fill"));
		panelAjustes.setBorder(BorderFactory.createTitledBorder("Ajustes"));

		JPanel panelServidor = new JPanel();
		panelServidor.setLayout(new MigLayout("fill, insets 0")); // fill es como un span
		panelServidor.add(new JToggleButton("PVP"), "growx");
		panelServidor.add(new JToggleButton("RPG"), "growx");
		panelAjustes.add(panelServidor, "spanx, growx");

		panelAjustes.add(new JToggleButton("¿Estas en grupo?"), "sg 1");
		panelAjustes.add(new JToggleButton("¿Sos renegado?"), "sg 1");
		panelAjustes.add(new JLabel("¿Cuantos son?"));
		cbGrupo = new JComboBox<String>();
		cbGrupo.setModel(new DefaultComboBoxModel<String>(new String[] { "2", "3", "4", "5" }));
		panelAjustes.add(cbGrupo, "growx, wrap");

		JPanel panelBotonesExp = new JPanel();
		panelBotonesExp.setLayout(new MigLayout("fill, insets 0"));
		panelBotonesExp.add(new JToggleButton("exp x2"), "sg 2");
		panelBotonesExp.add(new JToggleButton("oro x2"), "sg 2");
		panelBotonesExp.add(new JButton("+50%"), "sg 2");
		panelBotonesExp.add(new JButton("+100%"), "sg 2");
		panelBotonesExp.add(new JButton("+200%"), "sg 2, growx");
		panelAjustes.add(panelBotonesExp, "spanx, growx");

		getContentPane().add(panelAjustes, "spanx, growx");
		// AJUSTES

		// PJ
		panelPJ = new JPanel();
		panelPJ.setLayout(new MigLayout());
		panelPJ.setBorder(BorderFactory.createTitledBorder("PJ"));

		panelPJ.add(new JLabel("Nivel:"), "right");
		cbNivel = new JComboBox<String>();
		cbNivel.setModel(new DefaultComboBoxModel<String>(new String[] { "1", "2", "3", "4" }));
		panelPJ.add(cbNivel, "growx, wrap");
		panelPJ.add(new JLabel("Experiencia:"), "right");
		panelPJ.add(new JTextField(6));

		getContentPane().add(panelPJ, "growy");
		// PJ

		// NPC
		panelNPC = new JPanel();
		panelNPC.setLayout(new MigLayout("", "[right][fill]"));
		panelNPC.setBorder(BorderFactory.createTitledBorder("NPC"));

		JPanel panelRadio = new JPanel();
		panelRadio.setLayout(new MigLayout("insets 0"));
		ButtonGroup grupo = new ButtonGroup();
		// JRadioButton mayorExp = new JRadioButton("+exp");
		// mayorExp.setFont(new Font("Consolas", Font.PLAIN, 11));
		JRadioButton mayorExp = new JRadioButton("+exp");
		mayorExp.setFont(new Font("Consolas", Font.PLAIN, 11));
		JRadioButton menorExp = new JRadioButton("-exp");
		menorExp.setFont(new Font("Consolas", Font.PLAIN, 11));
		JRadioButton rinde = new JRadioButton("vida/oro");
		rinde.setFont(new Font("Consolas", Font.PLAIN, 11));
		JRadioButton alfabeto = new JRadioButton("abc");
		alfabeto.setFont(new Font("Consolas", Font.PLAIN, 11));
		grupo.add(mayorExp);
		grupo.add(menorExp);
		grupo.add(rinde);
		grupo.add(alfabeto);
		panelRadio.add(mayorExp);
		panelRadio.add(menorExp);
		panelRadio.add(rinde);
		panelRadio.add(alfabeto);
		panelNPC.add(panelRadio, "spanx, wrap");

		panelNPC.add(new JLabel("Nombre:"));
		cbNPC = new JComboBox<String>();
		cbNPC.setModel(new DefaultComboBoxModel<String>(new String[] { "Cría de Dragón Legendario" }));
		panelNPC.add(cbNPC, "wrap");
		panelNPC.add(new JLabel("Experiencia:"));
		panelNPC.add(new JTextField(), "spanx");
		panelNPC.add(new JLabel("Vida:"));
		panelNPC.add(new JTextField(), "spanx");
		panelNPC.add(new JLabel("Oro:"));
		panelNPC.add(new JTextField(), "spanx");

		getContentPane().add(panelNPC, "wrap");
		// NPC

		panelCalculadora = new JPanel();
		// Restriccion de dise�o
		// - Ajuste atumatico cada 2 componentes
		// - Reclama todo el espacio disponible en el contenedor para las columnas/filas
		panelCalculadora.setLayout(new MigLayout("wrap 2, fill", "[grow 0, right][fill]")); // La primera columna no se va a llenar
		panelCalculadora.setBorder(BorderFactory.createTitledBorder("Calculadora"));

		panelCalculadora.add(new JLabel("Porcentaje de experiencia que otorga el NPC:"));
		panelCalculadora.add(new JTextField());
		panelCalculadora.add(new JLabel("Total de NPCs a matar para subir de nivel:"));
		panelCalculadora.add(new JTextField());
		panelCalculadora.add(new JLabel("Total de oro a conseguir:"));
		panelCalculadora.add(new JTextField());
		panelCalculadora.add(new JButton("CALCULAR EXPERIENCIA Y ORO"), "spanx, growx");

		getContentPane().add(panelCalculadora, "spanx, growx");

		getContentPane().add(getBotonesPanel(), "spanx, growx");

		pack();
		setLocationRelativeTo(null);

	}

	private JPanel getBotonesPanel() {
		MigLayout layout = new MigLayout("insets 0", "[][grow, right]");
		JPanel panel = new JPanel();
		panel.setLayout(layout);

		panel.add(new JLabel("by Ru$o"));

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {

			}
		});

		btnNuevo = new JButton("Boton");
		btnNuevo.requestFocusInWindow();
		panel.add(btnNuevo);

		panel.add(btnActualizar, "split 2,alignx right");

		btnAcerca = new JButton("Acerca de...");
		btnAcerca.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if (evt.getSource() == btnAcerca) {

				}
			}
		});
		panel.add(btnAcerca, "");

		return panel;
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		new PrototipoCalculadora().setVisible(true);
	}

}
