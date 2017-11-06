package com.redgate.development.tests.readers;

import java.io.EOFException;

public interface ICharacterReader {
	char GetNextChar() throws EOFException;
	void Dispose();
}
