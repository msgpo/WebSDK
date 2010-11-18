/* License (MIT)
 * Copyright 2009 Sony Ericsson Mobile Communications AB
 * website: http://developer.sonyericsson.com/
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * Software), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package Utilities;

import java.util.Enumeration;
import java.util.Vector;

public class AbstractHelper implements Helper {

  private Vector<HelperListener> listeners;

  public AbstractHelper() {
    listeners = new Vector<HelperListener>();
  }

  protected void fireNewMessage(String message) {
    Enumeration<HelperListener> elements = listeners.elements();
    while (elements.hasMoreElements()) {
      HelperListener listener = elements.nextElement();

      listener.newMessage(message);
    }
  }

  @Override
  public void addListener(HelperListener listener) {
    listeners.add(listener);
  }

  @Override
  public void removeListener(HelperListener listener) {
    listeners.remove(listener);
  }
}
