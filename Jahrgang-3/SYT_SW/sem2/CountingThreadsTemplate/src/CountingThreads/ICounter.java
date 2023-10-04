/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CountingThreads;

/**
 *
 * @author syt@htl-leonding.ac.at
 */
public interface ICounter {
    void set(int start);
    int get();
    void increment();
}
