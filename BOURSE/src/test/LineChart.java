package test;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;

import java.awt.BasicStroke; 
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Minute;
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities;

import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class LineChart extends ApplicationFrame implements Runnable
{
	private boolean stop = true;
	private XYSeriesCollection dataset = new XYSeriesCollection( );  
	private XYSeries firefox = new XYSeries( "Firefox" ); 
	private XYSeries chrome = new XYSeries( "Chrome" ); 
	private  LineChart instance=this;
	private static int x=0;
	private static int y=0;
	
	
	private static JButton start= new JButton("start");
	
   public LineChart( String applicationTitle, String chartTitle )
   {
      super(applicationTitle);
      JFreeChart xylineChart = ChartFactory.createXYLineChart(chartTitle , "Category" , "Score" , dataset ,  PlotOrientation.VERTICAL , true , true , false);
      dataset.addSeries( firefox );          
      dataset.addSeries( chrome );    
      ChartPanel chartPanel = new ChartPanel( xylineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      final XYPlot plot = xylineChart.getXYPlot( );
      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
      renderer.setSeriesPaint( 0 , Color.blue);
      renderer.setSeriesPaint( 1 , Color.red);
      renderer.setSeriesPaint( 2 , Color.YELLOW );
     /* renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
      renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
      renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );*/
      plot.setRenderer( renderer ); 
      setContentPane( chartPanel );
      
      start.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!stop) {
					stop = true;
					start.setText(" Start ");
				} else {
					stop = false;
					start.setText(" Pause ");
					Thread chronoThread = new Thread(instance);
					chronoThread.start();
				}
			}
			
		});
   }
   
  /* private XYDataset createDataset( )
   {
             
    
     
      
             
     final XYSeries iexplorer = new XYSeries( "InternetExplorer" );          
      iexplorer.add( 3.0 , 4.0 );          
      iexplorer.add( 4.0 , 5.0 );          
      iexplorer.add( 5.0 , 4.0 );         
              
      dataset.addSeries( firefox );          
     dataset.addSeries( chrome );          
     // dataset.addSeries( iexplorer );
      return dataset;
   }
*/
   public static void main( String[ ] args ) 
   {
      LineChart chart = new LineChart("boussad's tests", "two charts in one panel");
      chart.pack( );          
     // RefineryUtilities.centerFrameOnScreen( chart );          
      chart.setVisible( true );
    //  Thread chronoThread = new Thread();
	//	chronoThread.start();
      chart.add(start);
   }

@Override
public void run() {
	while (!stop) {
		try {
			Thread.sleep((long) (10000*Math.random()));
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		 firefox.add( x++ ,Math.random());      
		 chrome.add( y++ ,Math.random());      
	 
		
	}
	
}
}