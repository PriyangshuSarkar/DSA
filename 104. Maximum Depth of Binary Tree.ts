class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;
  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

function maxDepth(root: TreeNode | null): number {
  return helper(root, 0);
}

function helper(root: TreeNode | null, level: number): number {
  if (root === null) return level;

  level++;

  const left = helper(root.left, level);
  const right = helper(root.right, level);

  return Math.max(left, right);
}
