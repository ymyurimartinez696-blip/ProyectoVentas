import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaVentas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVentas frame = new VentanaVentas();
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
	public VentanaVentas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Generar Reporte");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
	            try {
	                // Esto ejecuta la lógica de creación de archivos
	                proyectoventas.GenerateInfoFiles.main(null); 
	                
	                // Esto abre una ventanita avisando que terminó
	                javax.swing.JOptionPane.showMessageDialog(null, "¡Archivos generados con éxito!");
	            } catch (Exception ex) {
	                ex.printStackTrace();
	                javax.swing.JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	            }
	        }
	    }); // Aquí se cierra el botón
	    btnNewButton.setBounds(174, 10, 150, 30);
	    contentPane.add(btnNewButton);
	} // Aquí se cierra el constructor VentanaVentas
	} // Aquí se cierra la clase completa