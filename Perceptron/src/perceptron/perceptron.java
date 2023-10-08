package perceptron;

public class perceptron {
	
    int maxIteration = 500;
    int iteration = 0;
    double eta = 1;
    double yin=0;
    int errors=0;
	
	public void Train(double [][] inputs , double [] output,double[] weight) {
		iteration=0;
		  do {
			  errors = 0;
			  iteration++;
			  for (int i = 0; i < 14 ; i++) {
				  
                yin = (inputs[i][0] * weight[0]) + (inputs[i][1] * weight[1]) + (inputs[i][2] * weight[2]);
                if (Math.signum(yin)!= output[i])
                {
                   errors ++;
                
                for (int j = 0; j <= 2; j++)
                {
                    weight[j] = weight[j] + (output[i] * inputs[i][j] * eta);
                 }
               }
			  }
			
		} while (errors != 0 && iteration < maxIteration);
		  perceptron p2 = new perceptron();
		  p2.print(weight ,iteration);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      double [][] inputs = {{1,3,0.2},{1,1,0.3},{1,4,0.5},{1,2,0.7},{1,0,1},{1,1,1.2},{1,1,1.7},
    		  {1,6,0.2},{1,7,0.3},{1,6,0.7},{1,3,1.1},
    		  {1,2,1.5},{1,4,1.7},{1,2,1.9}};
      double [] output  = {-1,-1,-1,-1,-1,-1,-1,1,1,1,1,1,1,1};
      double [] firstWeight  = {0.2, 5.1, 2.3};
      double [] secondWeight  = {1.0, 1.0, 1.0};
      perceptron p = new perceptron();
      p.Train(inputs,output,firstWeight);
      p.Train(inputs, output, secondWeight);
	}
    public void print(double[] weight , int iteration) {
    	for(int i=0; i<3 ; i++) {
    	System.out.println(weight[i]);
    	}
    	System.out.println("iteration = " + iteration);
    }
}
