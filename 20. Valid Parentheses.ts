function isValid(s: string): boolean {
  const stack: string[] = [];

  for (const char of s) {
    if (char === "(" || char === "{" || char === "[") {
      stack.push(char);
    } else if (char === ")" && topItem(stack) !== "(") {
      return false;
    } else if (char === "}" && topItem(stack) !== "{") {
      return false;
    } else if (char === "]" && topItem(stack) !== "[") {
      return false;
    } else stack.pop();
  }

  function topItem(stack: string[]): string {
    return stack[stack.length - 1];
  }

  return stack.length === 0;
}

