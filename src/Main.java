import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;


public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtext;
	private JTextField txttarget;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 711);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCopyTo = new JLabel("Copy to : ");
		lblCopyTo.setBounds(10, 40, 80, 20);
		contentPane.add(lblCopyTo);
		
		JLabel lblExt = new JLabel("Extensions : ");
		lblExt.setBounds(10, 10, 80, 20);
		contentPane.add(lblExt);
		
		txtext = new JTextField();
		txtext.setText("JPG;AVI;WMV;MP3;JPEG;BMP");
		txtext.setBounds(80, 10, 250, 20);
		contentPane.add(txtext);
		txtext.setColumns(10);
		
		txttarget = new JTextField();
		txttarget.setText("H:\\");
		txttarget.setBounds(80, 40, 250, 20);
		contentPane.add(txttarget);
		txttarget.setColumns(10);
		
		final JTextArea txtarea = new JTextArea();
		txtarea.setBounds(10, 70, 500, 600);
		contentPane.add(txtarea);
		
		JButton btngo = new JButton("Start");
		btngo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Target = txttarget.getText();
				String ext = txtext.getText();
				File[] roots = File.listRoots();
				for(int i=0 ; i<roots.length ; i++){
					String driveltr = String.valueOf(roots[i]).substring(0,1);
					try {
						CopyFiles.Go(String.valueOf(roots[i]) , Target + "FoundFiles\\" + driveltr + "\\" , ext , txtarea );
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btngo.setBounds(340, 10, 89, 20);
		contentPane.add(btngo);
	}
}
