/*
 * Program Porównywanie Kolekcji
 * Autor: Roman Kovalchuk
 * Data: 11 grudnia 2016 r.
 */  
    import java.awt.Dimension;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.*;
	import javax.swing.*;
	import javax.swing.table.DefaultTableModel;

public class PorownajKolekcje  extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	Vector<String> vector = new Vector<String>();
	ArrayList<String> arraylist  = new ArrayList<String>();
	LinkedList<String> linkedlist = new LinkedList<String>();
	HashSet<String> hashset = new HashSet<String>();
	TreeSet<String> treeset = new TreeSet<String>();
	
	
	WidokKolekcji widokVector;
	WidokKolekcji widokArrayList;
	WidokKolekcji widokLinkedList;
	WidokKolekcji widokHashSet;
	WidokKolekcji widokTreeSet;
	
	
	JLabel etykieta_tytulu = new JLabel("Tytuł: " );
	JTextField pole_tytul = new JTextField(10);
	JButton przycisk_dodaj = new JButton("Dodaj");
	JButton przycisk_usun = new JButton("Usuń");
	JButton przycisk_posortuj = new JButton("Soruj Listy");
	JButton przycisk_wyczysc = new JButton("Wyczyść");
	JButton przycisk_autor = new JButton("Autor");
	JButton przycisk_opis = new JButton("Opis");
    	
	
	
	public PorownajKolekcje(){
		super("Porównanie działania kolekcji");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(650, 550);
		
		JPanel panel = new JPanel();
		panel.add(etykieta_tytulu);
		panel.add(pole_tytul);
		
		przycisk_dodaj.addActionListener(this);
		panel.add(przycisk_dodaj);
		
		przycisk_usun.addActionListener(this);
		panel.add(przycisk_usun);

		przycisk_posortuj.addActionListener(this);
		panel.add(przycisk_posortuj);
		
		przycisk_wyczysc.addActionListener(this);
		panel.add(przycisk_wyczysc);
		
		przycisk_autor.addActionListener(this);
		panel.add(przycisk_autor);
		
		przycisk_opis.addActionListener(this);
		panel.add(przycisk_opis);
		
		widokVector = new WidokKolekcji(vector, 150, 200, "Vector:" );
		panel.add(widokVector);
		
		widokArrayList = new WidokKolekcji(arraylist, 150, 200, "ArrayLIst:");
		panel.add(widokArrayList);
		
		widokLinkedList = new WidokKolekcji(linkedlist, 150, 200, "LinkedList:");
		panel.add(widokLinkedList);
		
		widokHashSet = new WidokKolekcji(hashset, 150, 200, "HashSet:");
		panel.add(widokHashSet);
		
		widokTreeSet = new WidokKolekcji(treeset, 150, 200, "TreeSet:");
		panel.add(widokTreeSet);
		
		setContentPane(panel);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg) {
	   String tytul;
	   Object zrodlo = arg.getSource();
	     
	     if(zrodlo == przycisk_dodaj){
	    	 tytul = pole_tytul.getText();
	    	 if(!tytul.equals("")){
	    		 vector.add(tytul); 
	    		 hashset.add(tytul); 
	    		 treeset.add(tytul); 
	    		 arraylist.add(tytul); 
	    		 linkedlist.add(tytul); 
	    		
	    		 
	    	 }
	     } else
	     
	    	 if(zrodlo == przycisk_wyczysc){
	    		 vector.clear();
	    		 arraylist.clear();
	    		 linkedlist.clear();
	    		 hashset.clear();
	    		 treeset.clear();
	    		 
	    		 
	    	 } else
	    		 if(zrodlo == przycisk_posortuj){
	    		 Collections.sort(vector);
	    		 Collections.sort(arraylist);
	    		 Collections.sort(linkedlist);
	    		 } else
	    		 if(zrodlo == przycisk_usun){
	    			 tytul = pole_tytul.getText();
	    			 vector.remove(tytul);
	    			 arraylist.remove(tytul);
	    			 linkedlist.remove(tytul);
	    			 hashset.remove(tytul);
	    			 treeset.remove(tytul);
	    		 } else
	    			 if(zrodlo == przycisk_autor){
	    				 JOptionPane.showMessageDialog(this, "Autor: Roman Kovalchuk");
	    			 } else
	    				 if(zrodlo == przycisk_opis){
	    					 JOptionPane.showMessageDialog(this, "Program, jaki porównuje działania kolekcji");
	    					 
	    				 }
	    			 
	    		 
	        widokVector.refresh();
	        widokArrayList.refresh();
	        widokLinkedList.refresh();
	        widokHashSet.refresh();
	        widokTreeSet.refresh();
		
	}
        
	   public static void main(String[] args){
		   new PorownajKolekcje();
	   }
	   
}
   class WidokKolekcji extends JScrollPane{
      private static final long serialVersionUID = 1L;
      private JTable tabela;
      private DefaultTableModel modelTabeli;
      Collection<String> kolekcja;
	  
      WidokKolekcji(Collection<String> kolekcja, int szerokosc, int wysokosc, String opis ){
      String[] kolumna = {"Tytuł:"};
      modelTabeli = new DefaultTableModel(kolumna, 0);
      tabela = new JTable(modelTabeli);
      tabela.setRowSelectionAllowed(false);
      this.kolekcja = kolekcja;
      setViewportView(tabela);
      setPreferredSize(new Dimension(szerokosc, wysokosc));
	  setBorder(BorderFactory.createTitledBorder(opis));
      }
    
      void refresh(){
    	   modelTabeli.setRowCount(0);
    	  Iterator<String> tytul = kolekcja.iterator();
    	  
    	  while (tytul.hasNext()) {
    		  String ntytul = (String) tytul.next();
    		  String [] wiersz = new String[] {ntytul};
    		  modelTabeli.addRow(wiersz);
    		  
     		  
    	  }
    	  
      }
 
 }
     	 
      
      
        	 
         
