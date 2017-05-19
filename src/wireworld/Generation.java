/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

/**
 *
 * @author mihasz
 */
public class Generation {
    
    private  CellGrid extendedgrid;
    private  CellGrid toreturngrid;

    
        public Generation(CellGrid basicgrid) {
           this.extendedgrid = new CellGrid(basicgrid.getHeights()+2, basicgrid.getWidths()+2);
           this.toreturngrid = new CellGrid(basicgrid.getHeights(),basicgrid.getWidths());
                 
        }
        
        public void copy(CellGrid basicgrid)  {
             for (int i = 1; i < extendedgrid.getHeights()-1; i++) {
                for (int j = 1; j <extendedgrid.getWidths()-1; j++) {
                    extendedgrid.getCell(i, j).setValue(basicgrid.getCell(i-1, j-1).getValue());
                }
            }
            extendedgrid.setCell(0, 0, basicgrid.getCell(basicgrid.getHeights(), 0).getValue());
            extendedgrid.setCell(0, extendedgrid.getWidths(), basicgrid.getCell(basicgrid.getHeights(), basicgrid.getWidths()).getValue());
            extendedgrid.setCell(extendedgrid.getHeights(), 0, basicgrid.getCell(0, 0).getValue());
            extendedgrid.setCell(extendedgrid.getHeights(),extendedgrid.getWidths(), basicgrid.getCell(0, basicgrid.getWidths()).getValue());  
        }     
        
        public void cut() {
            for (int i = 0; i < this.toreturngrid.getHeights(); i++) {
                for (int j = 0; j <this.toreturngrid.getWidths(); j++) {
                    this.toreturngrid.getCell(i, j).setValue(extendedgrid.getCell(i+1, j+1).getValue());
                }
            }
        }
  
   
        public CellGrid generate(CellGrid basicgrid) {
          copy(basicgrid);
            
            /* Tu następuje generacja */
            toreturngrid.setCell(0, 0, 0);
            cut();
            
            return toreturngrid;
        }
           
         
    }
    

