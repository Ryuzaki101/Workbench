package de.wisag.automation.micas.olt.internal.terminal.emulator;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.locks.ReentrantLock;

class StreamFilter {
    static final String ENCODING = "ISO-8859-1"; //$NON-NLS-1$
    final ReentrantLock lock = new ReentrantLock(false);
    StringBuffer sb = new StringBuffer();

    OutputStream attach(final OutputStream out) {
        return new OutputStream() {
            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                lock.lock();
                try {
                    out.write(b, off, len);
                } finally {
                    lock.unlock();
                }
            }

            @Override
            public void write(int b) throws IOException {
                lock.lock();
                try {
                    out.write(b);
                } finally {
                    lock.unlock();
                }
            }

            @Override
            public void close() throws IOException {
                out.close();
            }

            @Override
            public void flush() throws IOException {
                out.flush();
            }
        };
    }
}