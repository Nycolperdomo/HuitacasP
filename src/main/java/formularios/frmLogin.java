package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionUsuarios;

import model.UsuarioVo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmLogin extends JFrame {

	private final JPanel contentPane;
	private final JTextField txtUsuarioo;
	private final JPasswordField txtContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(61, 74, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(61, 123, 94, 14);
		contentPane.add(lblNewLabel_1);

		txtUsuarioo = new JTextField();
		txtUsuarioo.setBounds(131, 71, 105, 20);
		contentPane.add(txtUsuarioo);
		txtUsuarioo.setColumns(10);

		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(131, 120, 105, 20);
		contentPane.add(txtContrasena);

		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
			}
		});
		btnNewButton.setBounds(61, 168, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				salir();
			}
		});
		btnNewButton_1.setBounds(184, 168, 89, 23);
		contentPane.add(btnNewButton_1);
	}

	protected void ingresar() {
		String usuario = txtUsuarioo.getText();
		String contrasena = String.valueOf(txtContrasena.getPassword());

		GestionUsuarios gestionUsuario = new GestionUsuarios();

		UsuarioVo usuario2 = new UsuarioVo();

		usuario2.setCorreo(usuario);
		usuario2.setContrasena(contrasena);

		UsuarioVo usu = gestionUsuario.obtenerUsuario(usuario2);

		if (usu != null) {
			JOptionPane.showMessageDialog(contentPane, "Bienvenido");

			this.dispose();
			
			frmBienvenida bienvenida = new frmBienvenida();
			bienvenida.setVisible(true);

		} else {
			JOptionPane.showMessageDialog(contentPane, "Datos Invalidos", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	protected void salir() {
		// TODO Auto-generated method stub
		System.exit(0);
	}
}
