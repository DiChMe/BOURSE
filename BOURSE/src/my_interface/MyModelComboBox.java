package my_interface;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import data.Entreprise;

public class MyModelComboBox  implements ComboBoxModel{
   
	  ArrayList<Entreprise> data;
	  
	  public MyModelComboBox(){
		  
	  }
	  public void setData(ArrayList<Entreprise> data){
		  this.data=data;
	  }
	  
	  
	@Override
	public void addListDataListener(ListDataListener arg0) {
		
		
	}

	@Override
	public Object getElementAt(int arg0) {
		
		return data.get(arg0);
	}

	@Override
	public int getSize() {
		
		return data.size();
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getSelectedItem() {
		
		return null;
	}

	@Override
	public void setSelectedItem(Object arg0) {
		// TODO Auto-generated method stub
		
	}

}
