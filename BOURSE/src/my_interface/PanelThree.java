package my_interface;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelThree  extends JPanel{

		
		private JTextField txtNom;
		private JComboBox comboBox;

		public PanelThree(){
			super();
			setBounds(0, 0, 1350, 750);
			setLayout(null);
		    btnStart = new JButton("START");
			btnStart.setBounds(1004, 505, 153, 46);
			add(btnStart);
			
			
			JLabel lblParam = new JLabel("CRÉATION DE PSEUDONYME");
			lblParam.setHorizontalAlignment(SwingConstants.CENTER);
			lblParam.setBounds(112, 12, 1200, 40);
			add(lblParam);
			
			setBackground(new Color(70, 130, 180));
			
			JLabel lblLa = new JLabel("PSEUDONYME");
			lblLa.setHorizontalAlignment(SwingConstants.CENTER);
			lblLa.setBounds(188, 211, 144, 25);
			add(lblLa);
			
			
			JLabel lblCapital = new JLabel("capital");
			lblCapital.setHorizontalAlignment(SwingConstants.CENTER);
			lblCapital.setBounds(188, 290, 144, 31);
			add(lblCapital);
			
			txtNom = new JTextField();
			txtNom .setBounds(610, 211, 247, 25);
			add(txtNom );
			txtNom .setColumns(10);
			
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"5000", "10000", "15000", "30000", "50000", "75000", "100000", "250000", "500000", "1000000"}));
			comboBox.setMaximumRowCount(4);
			comboBox.setBounds(610, 290, 245, 31);
			add(comboBox);
			
		}
		private JButton btnStart;
		public JButton getBtnStart() {
			return btnStart;
		}

		public void setBtnStart(JButton btnStart) {
			this.btnStart = btnStart;
		}

		public JTextField getTxtNom() {
			return txtNom;
		}

		public void setTxtNom(JTextField txtNom) {
			this.txtNom = txtNom;
		}

		public JComboBox getComboBox() {
			return comboBox;
		}

		public void setComboBox(JComboBox comboBox) {
			this.comboBox = comboBox;
		}
	
		public void addAction(ActionListener l){
			
			getBtnStart().addActionListener(l);
			
		}
		

}
