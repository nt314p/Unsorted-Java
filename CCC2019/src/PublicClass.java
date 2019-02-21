public class PublicClass {

	public static void main(String[] args) {
		PrivateImpl impl = new PrivateImpl(10);

		System.out.println(impl.implementationData);
	}
}

class PrivateImpl {
	public int implementationData;

	public PrivateImpl(int n) {
		implementationData = n;
	}
}