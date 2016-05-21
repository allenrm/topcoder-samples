public class ABoardGame {
	private final static String ALICE = "Alice";
	private final static String BOB = "Bob";
	private final static String DRAW = "Draw";
	private final static char A = 'A';
	private final static char B = 'B';

	public String whoWins(String[] board) {
		int n = board.length/2;
		int aliceCount = 0;
		int bobCount = 0;

		for( int region = 1; region <= n; region++ ) {
			aliceCount = 0;
			bobCount = 0;

			int lowerSearch = n - region;
			int upperSearch = n + (region - 1);

			for( int row = lowerSearch; row <= upperSearch; row++ ) {
				for( int col = lowerSearch; col <= upperSearch; col++) {
					int lowerExclusion = n - (region - 1);
					int upperExclusion = n + (region - 2);

					if( region != 1
						&& ( ( row >= lowerExclusion && row <= upperExclusion )
							&& ( col >= lowerExclusion && col <= upperExclusion ) )
					)
						continue;

					char square = (board[row].toCharArray())[col];

					aliceCount += square == A ? 1 : 0;
					bobCount += square == B ? 1 : 0;
				}
			}

			if( aliceCount > bobCount || aliceCount < bobCount )
				return aliceCount > bobCount ? ALICE : BOB;
		}

		return DRAW;
	}
}