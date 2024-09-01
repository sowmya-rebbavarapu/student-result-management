
import java.sql.ResultSet;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
class DbUtils {

    static TableModel resultSetToTableModel(ResultSet rs) throws SQLException {
   ResultSetMetaData metaData = rs.getMetaData();

        // Get the number of columns
        int columnCount = metaData.getColumnCount();

        // Create a vector to hold column names
        Vector<String> columnNames = new Vector<>();

        // Populate column names
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // Create a vector to hold table data
        Vector<Vector<Object>> data = new Vector<>();

        // Populate table data
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                row.add(rs.getObject(columnIndex));
            }
            data.add(row);
        }

        // Create the DefaultTableModel with column names and data
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Close the ResultSet after processing
        rs.close();

        return model;
        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
