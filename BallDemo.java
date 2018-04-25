import java.awt.Color;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private BouncingBall[] myBalls;
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int bolas)
    {
        int ground = 400;   // position of the ground line
        
        myBalls = new BouncingBall[bolas];
        
        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // creamos tantas bolas como indique el usuario
        
        for (int i=0; i <bolas; i++){
            BouncingBall ball = new BouncingBall (50 + (10*i), 50,10,Color.red, ground,myCanvas);
            ball.draw();
            myBalls[i] = ball;
        }
        
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            
            
            for (int i =0; i<bolas; i++){
                myBalls[i].move();
                // stop once ball has travelled a certain distance on x axis
                if(myBalls[i].getXPosition() >= 550) {
                finished = true;
            }
            }
            
            
           
        }
    }
}
