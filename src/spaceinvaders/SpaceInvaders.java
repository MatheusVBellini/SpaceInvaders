package spaceinvaders;

/**
 *
 * Matheus Violaro Bellini
 * Número USP: 12547600
 * 
 * Engenharia de Computação
 * Escola de Engenharia de São Carlos (EESC-USP)
 * Instituto de Ciências Matemáticas e de Computação (ICMC-USP)
 * 
 */
public class SpaceInvaders {

    public static void main(String[] args) {
        long frameRate = 60;

        // game loop
        while (true) {
            // start time counting
            long start = System.currentTimeMillis();
            
            // processInput()
            // update()
            // render()
            
            // wait the correct amount of time for the cycle to end
            try {
                Thread.sleep((long)(100/frameRate) + start - System.currentTimeMillis());
            } catch (IllegalArgumentException ex) {
                // do nothing -- framerate lower than expected
            } catch (InterruptedException ex) {
                System.out.println("Thread interrupted");
            }
        }
    }
    
}
