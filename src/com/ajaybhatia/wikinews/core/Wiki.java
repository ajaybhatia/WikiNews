/*
 * The MIT License
 *
 * Copyright 2014 Ajay Bhatia <prof.ajaybhatia@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.ajaybhatia.wikinews.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Ajay Bhatia <prof.ajaybhatia@gmail.com>
 */
public class Wiki {
    private Document document;

    public Wiki() {
        try {
            document = Jsoup.connect("http://en.wikipedia.org/").get();
        } catch (IOException ex) {
            Logger.getLogger(Wiki.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<String> headlines() {
        ArrayList<String> news = new ArrayList<>();
        Iterator<Element> it = document.select("#mp-itn li").iterator();
        while (it.hasNext()) 
            news.add(it.next().text());
        
        return news;
    }    
}
