package info.dmerej;

import info.dmerej.stubs.AuthorizerStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SafeCalculatorTest {
  private AuthorizerStub authorizer;

  @BeforeEach
  public void setUp() {
    this.authorizer = new AuthorizerStub();
  }

  @Test
  void should_not_throw_when_authorized() {
    // TODO: write a test to demonstrate the bug in SafeCalculator.add()
    // Given
    Authorizer authorizer = this.authorizer.setAuthorized(true);
    SafeCalculator safeCalculator = new SafeCalculator(authorizer);

    // When
    int res = safeCalculator.add(1, 2);

    // Then
    Assertions.assertEquals(3, res);
  }
}
