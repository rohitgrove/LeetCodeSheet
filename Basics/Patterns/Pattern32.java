public class Pattern32 {
	public static void main(String[] args) {
		int n = 5;
		int row = 1;
		int total_st = 0;
		int row_number_num = 1;

		while (row <= 2 * n - 1) {
			int cnt_st = 0;
			while (cnt_st <= total_st) {
				if (cnt_st <= 0) {
					System.out.print(" ");
				} else {
					System.out.print(" * ");
				}
				System.out.print(row_number_num);
				cnt_st++;
			}

			System.out.println();
			row++;
			if (row <= n) {
				total_st = total_st + 1;
				row_number_num = row_number_num + 1;
			} else {
				row_number_num--;
				total_st--;
			}
		}
	}
}
