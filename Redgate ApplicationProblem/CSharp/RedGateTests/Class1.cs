using System;

namespace RedGateTests
{
	public interface ICharacterReader : IDisposable
	{
		char GetNextChar();
	}

	public class SimpleCharacterReader : ICharacterReader
	{
		private int m_Pos=0;
		private string m_Content=@"	
It was the best of times, it was the worst of times,
it was the age of wisdom, it was the age of foolishness,
it was the epoch of belief, it was the epoch of incredulity,
it was the season of Light, it was the season of Darkness,
it was the spring of hope, it was the winter of despair,
we had everything before us, we had nothing before us,
we were all going direct to Heaven, we were all going direct
the other way--in short, the period was so far like the present
period, that some of its noisiest authorities insisted on its
being received, for good or for evil, in the superlative degree
of comparison only.

There were a king with a large jaw and a queen with a plain face,
on the throne of England; there were a king with a large jaw and
a queen with a fair face, on the throne of France.  In both
countries it was clearer than crystal to the lords of the State
preserves of loaves and fishes, that things in general were
settled for ever";

		public SimpleCharacterReader()
		{
		}

		public char GetNextChar()
		{
			if (m_Pos>=m_Content.Length)
			{
				throw new System.IO.EndOfStreamException();
			}

			return m_Content[m_Pos++];
		}

		public void Dispose()
		{
			//do nothing
		}
	}

}