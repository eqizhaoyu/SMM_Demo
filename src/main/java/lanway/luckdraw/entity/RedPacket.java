package lanway.luckdraw.entity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description TODO(用一句话描述该文件做什么)
 * @author 戚兆宇
 * @date 2018年1月22日 上午11:48:03
 *
 */
public class RedPacket {
	public static void main(String[] args) {
		// 红包数
		int number = 10;
		// 红包总额
		float total = 100;
		// 最小红包
		double min = 0.01;

		getRed(number, total, min);
	}

	public static List getRed(int number, float total, double min) {

		float money;

		double max;

		int i = 1;
		List math = new ArrayList();
		DecimalFormat df = new DecimalFormat("###.##");
		while (i < number) {
			// 保证即使一个红包是最大的了,后面剩下的红包,每个红包也不会小于最小值
			max = total - min * (number - i);
			int k = (int) (number - i) / 2;
			// 保证最后两个人拿的红包不超出剩余红包
			if (number - i <= 2) {
				k = number - i;
			}
			// 最大的红包限定的平均线上下
			max = max / k;
			// 保证每个红包大于最小值,又不会大于最大值
			money = (int) (min * 100 + Math.random() * (max * 100 - min * 100 + 1));
			money = (float) money / 100;
			// 保留两位小数
			money = Float.parseFloat(df.format(money));
			total = (int) (total * 100 - money * 100);
			total = total / 100;
			math.add(money);
			System.out.println("第" + i + "个人拿到" + money + "剩下" + total);
			i++;
			// 最后一个人拿走剩下的红包
			if (i == number) {
				math.add(total);
				System.out.println("第" + i + "个人拿到" + total + "剩下0");
			}
		}
		// 取数组中最大的一个值的索引
		System.out.println("本轮发红包中第" + (math.indexOf(Collections.max(math)) + 1) + "个人手气最佳");
		return math;
	}
}
