//Grant Williams
//  gmw140030
//  CS 3345.003
//  Project 5
//IDE used NetBeans


/*  Times     | Pivot Points for the arrays
*** Run Times | FirstElement    | MedianOf3      | OneRandomInt   | 3RandomInts
*** 100       | PT0.000823273S  | PT0.000054787S | PT0.000184728S | PT0.007836118S
*** 50000     | PT0.018551264S  | PT0.01653478S  | PT0.0316475S
*/
/*First Element
*** for first Element pivot point the time starts at 100 elements at the 
*** ten thousandth .0008, at 1000 elements the time increases to thousandth
*** at .00159... and as the array gets larger, the time gets closer to 1 nanosecond
*/
/*Median of 3
*** for the Median of three elements it goes from hundred thousandth at 100 elements
*** then 0.01653478S, the hundredth decimal place at 50,000 elements 
*/
/* OneRandomInteger Pivot Points
*** Using OneRandomInteger for the pivot point insures that
*** the time in nanoseconds is based on what random integer is chosen
*** within arrays
*** at size 100 it starts at ten thousandth decimal place
*** at greater sizes it gets closer to the hundreth decimal place and then 1 nanosecond
*/
/* The same can be said of median of three random integers pivot
*** but at size 100 it starts at hundreth decimal place
*** this one does not work at 1000 up sizes
*/

/* getting to 1 nanosecond
*** it gets close at 1,000,000 elements
*/