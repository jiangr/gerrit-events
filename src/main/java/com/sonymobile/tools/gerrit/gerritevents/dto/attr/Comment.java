/*
 *  The MIT License
 *
 *  Copyright 2010 Sony Ericsson Mobile Communications.
 *  Copyright 2013 Sony Mobile Communications AB. All rights reserved.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */
package com.sonymobile.tools.gerrit.gerritevents.dto.attr;

import com.sonymobile.tools.gerrit.gerritevents.dto.GerritJsonDTO;
import net.sf.json.JSONObject;

import static com.sonymobile.tools.gerrit.gerritevents.GerritJsonEventFactory.getString;
import static com.sonymobile.tools.gerrit.gerritevents.dto.GerritEventKeys.*;

/**
 */
public class Comment implements GerritJsonDTO {

    private Account reviewer;
    private String message;

    public Comment() {
    }

    /**
     * Constructor that fills with data directly.
     *
     * @param json the JSON Object with data.
     * @see #fromJson(net.sf.json.JSONObject)
     */
    public Comment(JSONObject json) {
        this.fromJson(json);
    }

    @Override
    public void fromJson(JSONObject json) {
        message = getString(json, MESSAGE);
        if (json.containsKey(REVIEWER)) {
            reviewer = new Account(json.getJSONObject(REVIEWER));
        }
    }

    public String getMessage() {
        return message;
    }

    public Account getReviewer() {
        return reviewer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (message != null ? !message.equals(comment.message) : comment.message != null) return false;
        if (reviewer != null ? !reviewer.equals(comment.reviewer) : comment.reviewer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reviewer != null ? reviewer.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}