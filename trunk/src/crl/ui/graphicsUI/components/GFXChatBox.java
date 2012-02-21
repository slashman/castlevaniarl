package crl.ui.graphicsUI.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import sz.util.ImageUtils;
import crl.ui.graphicsUI.AddornedBorderPanel;
import crl.ui.graphicsUI.GFXDisplay;

public class GFXChatBox extends AddornedBorderPanel{
	private JLabel lblImageIcon;
	private JLabel lblName;
	private JTextArea txtText;
	
	public void set(Image pimg, String pname, String ptext){
		lblImageIcon.setIcon(new ImageIcon(pimg));
		lblName.setText(pname);
		txtText.setText(ptext);
	}
	
	public GFXChatBox(Image UPRIGHT, 
			Image UPLEFT, Image DOWNRIGHT, Image DOWNLEFT,
			Color OUT_COLOR, Color IN_COLOR,
			int borderWidth, int borderHeight){
		super(UPRIGHT, UPLEFT, DOWNRIGHT, DOWNLEFT, OUT_COLOR, IN_COLOR, borderWidth, borderHeight);
		lblImageIcon = new JLabel();
		lblName = new JLabel();
		txtText = new JTextArea();

		lblName.setFont(GFXDisplay.FNT_TITLE);
		lblName.setForeground(Color.WHITE);
		
		txtText.setWrapStyleWord(true);
		txtText.setLineWrap(true);
		txtText.setFont(GFXDisplay.FNT_DIALOGUEIN);
		txtText.setForeground(Color.WHITE);
		txtText.setEditable(false);
		txtText.setFocusable(false);
		
		txtText.setOpaque(false);
		lblName.setOpaque(false);
		lblImageIcon.setOpaque(false);
		setOpaque(false);
		
		lblImageIcon.setVerticalAlignment(SwingConstants.TOP);
		
		setBorder(new EmptyBorder(borderWidth,borderWidth,borderWidth,borderWidth));
		setLayout(new BorderLayout());
		((BorderLayout)getLayout()).setHgap(10);
		((BorderLayout)getLayout()).setVgap(10);
		add(lblImageIcon, BorderLayout.WEST);
		add(lblName, BorderLayout.NORTH);
		add(txtText, BorderLayout.CENTER);
		//setBackground(TRANSPARENT_BLUE);
	}
}
