import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import mode.Mode;
import mode.ModelFactory;


public class ButtonPanel extends JPanel implements ActionListener {
	final int funtionNum = 6;
	JButton[] funtionJB = new JButton[funtionNum];
	ImageIcon[] funtionIcon = new ImageIcon[funtionNum];
	
	Mode mode;
	//public PanelModel PModel = new PanelModel();
	ButtonPanel(){
		for(int i = 0; i < funtionNum;i++) {
			funtionIcon[i] = new ImageIcon("image\\"+ i +".png");
			funtionJB[i] = new JButton(funtionIcon[i]);
			funtionJB[i].setBackground(Color.white);
			funtionJB[i].setActionCommand("" + i);
			funtionJB[i].addActionListener(this);
			
			this.add(funtionJB[i]);
			
		}
		
		this.setLayout(new GridLayout(funtionNum, 1));
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String cmd = arg0.getActionCommand();
		mode = ModelFactory.creatMode(Integer.parseInt(cmd));
		//PModel.ChangeStates(Integer.parseInt(cmd));
		changeButtonColor(Integer.parseInt(cmd));
	}
	void changeButtonColor(int selectfuntionNum) {
		for(int i = 0; i < funtionNum;i++) {
			if(selectfuntionNum == i) {
				funtionJB[i].setBackground(Color.black);
			}else {
				funtionJB[i].setBackground(Color.white);
			}
		}
	}
}

