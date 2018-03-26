# words-in-binary-tree
Basic example of binary tree.

Steps:
1) Given a text, extract all its words and, for each word, calculate a weight as the frequency of that word in the
text;
2) Build a binary tree containing all extracted words on its leaves. Each leaf will have a depth inversely
proportional to the weight of its word: the lower the weight of a word is, the deeper the word will appear in the
tree;
3) For each word in the tree, calculate a code made of 0’s and 1’s as a path from the root of the tree to the
word’s leaf, whereby 0 means traversing a left branch and 1 means traversing a right branch;
4) Output the original sequence of words as their binary codes, each code separated by a dash.

Advanced:
1) Build a Spring Boot application with a basic web client. The web UI should allow the user to enter a text,
submit the text to the server and get the binary-code transformation back.
2) The server should save the text submitted by the client into a database, together with its binary-code
representation, and return the binary-code string to the client.
