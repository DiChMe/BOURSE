package panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameTest extends JFrame {
	
	private PanelOne p1;
	private PanelTwo p2;

	public FrameTest(){
		super("boussad's tests");
		
		setLayout(null);
		setSize(710,500);
		setVisible(true);
		 p1= new PanelOne();
		//p1.setVisible(true);
		add(p1);
		p1.getBtn().addActionListener(new ChaneListener());
		p2= new PanelTwo();
		
		p2.setVisible(false);
		add(p2);
		p2.getBtn().addActionListener(new ChanListener());
	}

	
	public static void main(String[]args){
		
		new FrameTest();
	}
	
	class ChaneListener implements ActionListener{


		@Override
		public void actionPerformed(ActionEvent arg0) {
			p1.setVisible(false);
			p2.setVisible(true);
			
		}
		
		
	}
	class ChanListener implements ActionListener{


		@Override
		public void actionPerformed(ActionEvent arg0) {
			p2.setVisible(false);
			p1.setVisible(true);
			
		}
		
		
	}
}
