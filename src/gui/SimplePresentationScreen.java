package gui;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import entities.Student;
import java.awt.Toolkit;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField txtLU;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JTextField txtGithub;

	public SimplePresentationScreen(Student studentData) {		
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(new Dimension(615, 300));
		setResizable(false);
		setContentPane(contentPane);
		
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void init() {
		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss"); 
		LocalDateTime now = LocalDateTime.now();
		contentPane.setLayout(null);
		
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 216);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		
		JLabel LU = new JLabel("LU");
		
		JLabel Apellido = new JLabel("Apellido");
		
		JLabel Nombre = new JLabel("Nombre");
		
		JLabel Email = new JLabel("Email");
		
		JLabel Github = new JLabel("GitHub URL");
		
		txtLU = new JTextField();
		txtLU.setEditable(false);
		txtLU.setColumns(10);
		txtLU.setText(Integer.toString(studentData.getId()));
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setColumns(10);
		txtApellido.setText(studentData.getLastName());
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setText(studentData.getFirstName());
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setText(studentData.getMail());
		
		txtGithub = new JTextField();
		txtGithub.setEditable(false);
		txtGithub.setColumns(10);
		txtGithub.setText(studentData.getGithubURL());
		
		GroupLayout gl_tabInformation = new GroupLayout(tabInformation);
		gl_tabInformation.setHorizontalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING, false)
						.addComponent(Github, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
						.addComponent(Email, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(Nombre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(Apellido, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(LU, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(txtLU, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtGithub, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_tabInformation.setVerticalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtLU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(LU))
					.addGap(18)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.TRAILING)
						.addComponent(Apellido)
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(Nombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(Email)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(Github)
						.addComponent(txtGithub, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		tabInformation.setLayout(gl_tabInformation);
		contentPane.add(tabbedPane);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(441, 41, 157, 157);
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);	
		
		lblImage.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jordan.jpg")).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(lblImage);
		
		JLabel lblDate = new JLabel("Esta ventada fue generada el "+ date.format(now) +" a las "+ time.format(now));
		lblDate.setBounds(15, 240, 420, 13);
		contentPane.add(lblDate);
	}
}
