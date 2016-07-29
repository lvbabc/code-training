package com.lvb.regex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {

	public static void main(String[] args) {

		RegexPractice practice = new RegexPractice();
		//		practice.findNum();
		//		practice.findWords();
		//		practice.replacePractice();
		practice.reset();

		//		if (args.length < 2) {
		//			System.out.println("Usage:/n" + "java TestRegularExpression " + "characterSequence regularExpression+");
		//			System.exit(0);
		//		}
		//		System.out.println("Input: \"" + args[0] + "\"");
		//		for (int i = 1; i < args.length; i++) {
		//			System.out.println("Regular expression: \"" + args[i] + "\"");
		//			Pattern p = Pattern.compile(args[i]);
		//			Matcher m = p.matcher(args[0]);
		//			while (m.find()) {
		//				System.out.println("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1));
		//			}
		//		}

		Pattern pattern = Pattern.compile("[ab]{2}");
		Matcher matcher = pattern.matcher("abcdabefabghabijk");
		StringBuffer sBuffer = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sBuffer, "哈哈");

			System.out.println(sBuffer);
		}
		matcher.appendTail(sBuffer);
	}

	/**
	 * 匹配电话号码
	 */
	private void findNum() {
		BufferedReader in;
		File file = new File("src/main/resources/phonenum.txt");
		Pattern pattern = Pattern.compile("\\(\\d{3}\\)\\s\\d{3}-\\d{4}");
		Pattern pattern2 = Pattern.compile("(\\(\\d{3}\\)|\\d{3})\\s?(-|)?\\d{3}\\s?(-|)?\\d{4}");
		try {
			in = new BufferedReader(new FileReader(file));
			String s;
			while ((s = in.readLine()) != null) {
				Matcher matcher = pattern2.matcher(s);
				if (matcher.find()) {
					System.out.println(matcher.group());
				}
			}
			in.close();
		} catch (Exception e) {

		}
	}

	/**
	 * 匹配单词
	 */
	private void findWords() {
		String word = "The the theme of this article is the Java's regex package.";
		Pattern pattern = Pattern.compile("\\b((\\w+)\\s*)+\\b", Pattern.CASE_INSENSITIVE);
		String[] str1Arr = pattern.split(word);
		System.out.println(Arrays.toString(str1Arr));
		Matcher matcher = pattern.matcher(word);
		if (matcher.find()) {
			System.out.println(matcher.group(2));
		}
	}

	private void replacePractice() {
		// Match the specially-commented block of text above:
		String s = "/*! Here's a block of text to use as input to the regular expression matcher. Note that we'll first extract the block of text by looking for the special delimiters, then process the extracted block. !*/";
		Matcher mInput = Pattern.compile("\\/*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
		if (mInput.find()) {
			s = mInput.group(1); // Captured by parentheses
		}
		System.out.println(s);

		// Replace two or more spaces with a single space:
		s = s.replaceAll("\\s{2,}", "");
		System.out.println(s);

		// Replace one or more spaces at the beginning of each
		// line with no spaces. Must enable MULTILINE mode:
		s = s.replaceAll("(?m)^ +", "");
		System.out.println(s);

		s = s.replaceFirst("[aeiou]", "(VOWEL1)");
		System.out.println(s);

		StringBuffer sbuf = new StringBuffer();
		Pattern p = Pattern.compile("[aeiou]");
		Matcher m = p.matcher(s);
		// Process the find information as you
		// perform the replacements:
		while (m.find()) {
			m.appendReplacement(sbuf, m.group().toUpperCase());
		}
		m.appendTail(sbuf);
		System.out.println(sbuf);
		// Put in the remainder of the text:
	}

	/*
	 * 如果不给参数，reset( )会把Matcher设到当前字符串的开始处。
	 */
	private void reset() {
		Matcher m = Pattern.compile("[frb][aiu][gx]").matcher("fix the rug with bags");
		while (m.find()) {
			System.out.println(m.group());
		}
		m.reset("fix the rig with rags");
		while (m.find()) {
			System.out.println(m.group());
		}
	}
}
