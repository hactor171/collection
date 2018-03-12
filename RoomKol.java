/*
 * Program Kolekcja Pokoje
 * Autor: Roman Kovalchuk
 * Data: 11 grudnia 2016 r.
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



class Room implements Comparable <Room> {
	private String symbol;
	private int numer;
	private String opis;
	
	public Room (String symbol, int numer , String opis){
		this.symbol = symbol;
		this.numer = numer;
		this.opis = opis;
		
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numer;
		result = prime * result + symbol.hashCode();
		return result;
	}


	@Override
	public String toString() {
		return symbol + "/" + numer + ":" + opis;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (symbol.equals(other.symbol) && numer==other.numer){
			
			return true;
			
		}
		return false;
	}


	@Override
	public int compareTo(Room room) {
		int comparedVal = this.symbol.compareTo(room.symbol);
		
		if (comparedVal == 0) {
			comparedVal = new Integer(this.numer).compareTo(new Integer(room.numer));
		}
		
		return comparedVal;
	}

}

public class RoomKol extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	Vector<Room> vector = new Vector<Room>(); 
	ArrayList<Room> arraylist = new ArrayList<Room>(); 
	LinkedList<Room> linkedlist = new LinkedList<Room>(); 
	HashSet<Room> hashset = new HashSet<Room>(); 
	TreeSet<Room> treeset = new TreeSet<Room>(); 
	
	WidokRoomKol widokVector;
	WidokRoomKol widokArrayList;
	WidokRoomKol widokLinkedList;
	WidokRoomKol widokHashSet;
	WidokRoomKol widokTreeSet;
	
	JLabel etykieta_symbolu = new JLabel("Symbol budynku:");
	JLabel etykieta_numeru = new JLabel("Numer pokoju:");
	JLabel etykieta_opisu = new JLabel("Opis:");
	JTextField pole_symbol = new JTextField(10);
	JTextField pole_numer = new JTextField(10);
	JTextField pole_opis = new JTextField(10);
	JButton przycisk_dodaj = new JButton("Dodaj");
	JButton przycisk_usun = new JButton("Usuń");
	JButton przycisk_wyczysc = new JButton("Wyczyść");
	JButton przycisk_autor = new JButton("Autor");
	
    public RoomKol(){
    	super("Kolekcja Pokoje");
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setSize(550, 550);
    	
    	JPanel panel = new JPanel();
    	panel.add(etykieta_symbolu);
    	panel.add(pole_symbol);
    	panel.add(etykieta_numeru);
    	panel.add(pole_numer);
    	panel.add(etykieta_opisu);
    	panel.add(pole_opis);
    	
    	przycisk_dodaj.addActionListener(this);
		panel.add(przycisk_dodaj);
		
		przycisk_usun.addActionListener(this);
		panel.add(przycisk_usun);
	
		przycisk_wyczysc.addActionListener(this);
		panel.add(przycisk_wyczysc);
		
		przycisk_autor.addActionListener(this);
		panel.add(przycisk_autor);
		
		widokVector = new WidokRoomKol(vector, 120, 200, "Vector:");
		panel.add(widokVector); 
		widokArrayList = new WidokRoomKol(arraylist, 120, 200, "ArrayList:");
		panel.add(widokArrayList);
		widokLinkedList = new WidokRoomKol(linkedlist, 120, 200, "LinkedList:");
		panel.add(widokLinkedList);
		widokHashSet = new WidokRoomKol(hashset, 120, 200, "HashSet:");
		panel.add(widokHashSet);
		widokTreeSet = new WidokRoomKol(treeset, 120, 200, "TreeSet:");
		panel.add(widokTreeSet);
		
		setContentPane(panel);
		setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent arg) {
		String symbol, opis;
		int numer;
		Object zrodlo = arg.getSource();
		Room room ;
		
		if(zrodlo == przycisk_dodaj){
			symbol = pole_symbol.getText();
			numer = Integer.parseInt(pole_numer.getText());
			opis = pole_opis.getText();
			room = new Room (symbol, numer, opis);
			if(!room.equals("")){
				vector.add(room);
				arraylist.add(room);
				linkedlist.add(room);
				hashset.add(room);
				treeset.add(room);
				
				
			 
				
			}
		
		}else
		     
	    	 if(zrodlo == przycisk_wyczysc){
	    		 vector.clear();
	    		 arraylist.clear();
	    		 linkedlist.clear();
	    		 hashset.clear();
	    		 treeset.clear();
	    		 
	    		 
	    	 } else
	    		
	    		 if(zrodlo == przycisk_usun){
	    		     symbol = pole_symbol.getText();
	    			 numer = pole_numer.getCaretPosition();
	    			 opis = pole_opis.getText();
	    			 room = new Room (symbol, numer, opis);
	    			   vector.remove(room);
	    			   arraylist.remove(room);
	    			   linkedlist.remove(room);
	    			   hashset.remove(room);
	    			   treeset.remove(room);
	    		 } else
	    			 if(zrodlo == przycisk_autor){
	    				 JOptionPane.showMessageDialog(this, "Autor: Roman Kovalchuk");
	    			 } 
		
		widokVector.refresh();
		widokArrayList.refresh();
		widokLinkedList.refresh();
		widokHashSet.refresh();
		widokTreeSet.refresh();
		
		
		
	}
	   public static void main(String[] args){
		   new RoomKol();
	   }
	
    class WidokRoomKol extends JScrollPane {
	private static final long serialVersionUID = 1L;
	private JTable tabela;
	private DefaultTableModel modelTabeli;
	Collection<Room> kolekcjaroom; 
	
	WidokRoomKol(Collection<Room> kolekcjaroom, int szerokosc, int wysokosc, String Opis){
	String[] kolumna = {""};
	modelTabeli = new DefaultTableModel(kolumna, 0);
	tabela = new JTable(modelTabeli);
	tabela.setRowSelectionAllowed(false);
	this.kolekcjaroom = kolekcjaroom;
	setViewportView(tabela);
	setPreferredSize(new Dimension(szerokosc, wysokosc));
	setBorder(BorderFactory.createTitledBorder(Opis));
		
		
	}
	void refresh(){
		modelTabeli.setRowCount(0);
		Iterator<Room> room = kolekcjaroom.iterator();
		
		while (room.hasNext()){
			Room nroom = (Room) room.next();
			Room [] wiersz = new Room[] {nroom};
			modelTabeli.addRow(wiersz);
		}
		
	}
	  
  }
	

}
