package matrix;

public class Client {

	public static void main(String[] args) throws ExceptMatrix {
		// TODO Auto-generated method stub
		DenseMatrix matrice = new DenseMatrix(3,2);
		matrice.write();
		System.out.println(matrice.toString());
		System.out.println(matrice.sum(matrice).toString());
		System.out.println(matrice.transpose().toString());
	}
}
