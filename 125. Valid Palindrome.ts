function isPalindrome(s: string): boolean {
  if (s.length <= 1) return true;

  let start: number = 0;
  let end: number = s.length - 1;

  while (start <= end) {
    if (!isAlphanumeric(s.charAt(start))) start++;
    else if (!isAlphanumeric(s.charAt(end))) end--;
    else if (s.charAt(start).toLowerCase() !== s.charAt(end).toLowerCase())
      return false;
    else {
      start++;
      end--;
    }
  }

  return true;
}

function isAlphanumeric(c: string): boolean {
  const code = c.charCodeAt(0);
  return (
    (code >= 48 && code <= 57) ||
    (code >= 65 && code <= 90) ||
    (code >= 97 && code <= 122)
  );
}
