public class AccessLevel {
	private static final char ALLOWED = 'A';
	private static final char DENIED = 'D';

	public String canAccess(int[] rights, int minPermission) {
		char[] users = new char[rights.length];

		for( int i = 0; i < rights.length; i++ ) {
			users[i] = rights[i] >= minPermission ? ALLOWED : DENIED;
		}

		return new String(users);
	}
}