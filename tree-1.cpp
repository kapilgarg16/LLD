#include <bits/stdc++.h>
using namespace std;

class Node {
public:
    int data;
    Node* left;
    Node* right;

    // Constructor
    Node(int value) {
        data = value;
        left = NULL;
        right = NULL;
    }
};

int main() {
    // Create root
    Node* root = new Node(10);

    // Left subtree
    root->left = new Node(5);
    root->left->left = new Node(3);
    root->left->right = new Node(7);

    // Right subtree
    root->right = new Node(20);
    root->right->right = new Node(30);

    rightSideView(root);

    return 0;
}
