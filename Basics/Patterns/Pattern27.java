public class Pattern27 {
	public static void main(String[] args) {
		int n = 5;
		int row = 1;
		int tots_num = 1;
		int tots_sp = n - 1;
		int num = 1;
		while (row <= n) {
			// space
			int cnt_sp = 0;
			while (cnt_sp < tots_sp) {
				System.out.print("  ");
				cnt_sp++;
			}
			// star!
			int cnt_st = 0;
			while (cnt_st < tots_num) {
				System.out.print(num + " ");
				if (cnt_st < tots_num / 2) {
					num++;
				} else {
					num--;
				}
				cnt_st++;
			}

			System.out.println();
			tots_num = tots_num + 2;
			tots_sp--;
			row++;
			num++;
		}
	}
}
