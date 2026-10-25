class MinStack {
  private stack: number[];
  private sortedStack: number[];
  constructor() {
    this.stack = new Array();
    this.sortedStack = new Array();
  }

  push(value: number): void {
    const min = this.sortedStack[this.sortedStack.length - 1];
    if (!this.sortedStack.length || value <= min) this.sortedStack.push(value);
    this.stack.push(value);
  }

  pop(): void {
    const top = this.stack.pop();
    const min = this.sortedStack[this.sortedStack.length - 1];
    if (top === min) this.sortedStack.pop();
  }

  top(): number {
    return this.stack[this.stack.length - 1];
  }

  getMin(): number {
    return this.sortedStack[this.sortedStack.length - 1];
  }
}

const obj = new MinStack();
obj.push(-2);
obj.push(0);
obj.push(-3);
console.log(obj.getMin());
console.log(obj.pop());
console.log(obj.top());
console.log(obj.getMin());
