/* Preorder can build the bst uniquely */
void readBSTHelper(int min, int max, int &insertVal, BinaryTree *&p, ifstream &fin) {
    if (insertVal > min && insertVal < max) {
        int val = insertVal;
        p = new BinaryTree(val);
        if (fin >> insertVal) {
            readBSTHelper(min, val, insertVal, p->left, fin);
            readBSTHelper(val, max, insertVal, p->right, fin);
        }
    }
}
 
void readBST(BinaryTree *&root, ifstream &fin) {
    int val;
    fin >> val;
    readBSTHelper(INT_MIN, INT_MAX, val, root, fin);
}