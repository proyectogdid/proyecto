package com.company.LP;



import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


import com.company.comun.itfProperty;

import static com.company.comun.clsConstantes.CAMPO_NOMBRE;


class ClasificacionModel extends AbstractTableModel
{
    private String[] columnNames = {"idDepartamento","Tipo","Jefe","Numero de Empleados"};
    Object[][] data;
    
    public ClasificacionModel(ArrayList<itfProperty>clasificados)
    {
    	
    	super();
    	
		int filas = clasificados.size();
		int cont;
		data=new Object[filas][];
		cont=0;
		
		
		//Nos recorremos el map para cargar la variable data[][]
		for (itfProperty b: clasificados)
		{
			Object[]a={b.getProperty(CAMPO_NOMBRE),
                    b.getProperty(CAMPO_NOMBRE),
            b.getProperty(CAMPO_NOMBRE),
                    b.getProperty(CAMPO_NOMBRE),};
			data[cont]=a;
			cont++;
		}
		
    	
    }
    
    public void setData(ArrayList<itfProperty> Departamentos)
    {
    	int filas = Departamentos.size();
		int cont;
		data=new Object[filas][];
		cont=0;
		
		
		for (itfProperty b: Departamentos)
		{
            Object[]a={b.getProperty(CAMPO_NOMBRE),
                    b.getProperty(CAMPO_NOMBRE),
                    b.getProperty(CAMPO_NOMBRE),
                    b.getProperty(CAMPO_NOMBRE),};
			data[cont]=a;
			cont++;
		}
    }
    
    
    
    
    
    public int getColumnCount() 
    {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
       
            return false;
       
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) 
    {
        
        data[row][col] = value;
        fireTableCellUpdated(row, col);

    }



}	


