// Local only: remove this import when pasting into LeetCode (it provides MinHeap).
import { MinHeap } from "./MinHeap.ts";

class KthLargest {
  private k: number;
  private heap: MinHeap<number>;
  constructor(k: number, nums: number[]) {
    this.k = k;
    this.heap = new MinHeap<number>();

    for (const num of nums) {
      this.pushWithLimit(num, this.k);
    }
  }

  private pushWithLimit(val: number, k: number): void {
    this.heap.push(val);

    if (this.heap.size() > k) this.heap.pop();
  }

  add(val: number): number {
    this.pushWithLimit(val, this.k);

    return this.heap.top()!;
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = new KthLargest(k, nums)
 * var param_1 = obj.add(val)
 */

const obj = new KthLargest(3, [4, 5, 8, 2]);

console.log(obj.add(3));
console.log(obj.add(5));
console.log(obj.add(10));
