package com.ideyatech.ut.exercise.calculator;

public class StringCalculator
{
	public long calculate(String input)
	{
		if (input != null)
			input = input.trim();

		// A
		if (input == null || input.isEmpty())
			return 0;

		long sum = 0;
		String delimeter = ",";

		String[] splitInput = input.split(delimeter);

		if (input.startsWith("//"))
		{
			input = input.substring(2);

			if (input.startsWith("["))
			{
				String[] splitForDelimeterString = input.split("]");

				if (splitForDelimeterString.length <= 0)
				{
					delimeter = "[";
				}
				else
				{
					delimeter = splitForDelimeterString[0].substring(1);
					input = input.substring(delimeter.length() + 2);
				}
			}
			else
			{
				delimeter = input.charAt(0) + "";
				input = input.substring(1);
			}

			if (!input.matches(String.format("[0-9%s ]*", delimeter)))
				throw new IllegalArgumentException();
		}

		long parsedInput = 0;

		try
		{
			parsedInput = Long.parseLong(input);
		}
		catch (Exception e)
		{
			String[] commaSplitString = input.split(delimeter);

			if (commaSplitString.length <= 0)
				throw new IllegalArgumentException();

			try
			{
				for (int i = 0; i < commaSplitString.length; i++)
				{
					parsedInput = Long.parseLong(commaSplitString[i].trim());

					if (parsedInput < 0)
						throw new IllegalArgumentException();

					if (parsedInput > 1000)
						continue;

					sum += Long.parseLong(commaSplitString[i].trim());
				}
				return sum;
			}
			catch (Exception e2)
			{
				throw new IllegalArgumentException();
			}

		}

		if (parsedInput < 0)
			throw new IllegalArgumentException();

		if (parsedInput > 1000)
			return 0;

		return parsedInput;

	}
}
