package seedu.address.model.tutee;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.model.person.Person;

/**
 * Tests that a {@code Tutee}'s {@code Education Level} matches any of the keywords given.
 */
public class EducationLevelContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public EducationLevelContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person tutee) {
        if (!(tutee instanceof Tutee)) {
            return false;
        } else {
            return keywords.stream()
                    .anyMatch(keyword -> StringUtil.containsWordIgnoreCase((
                            (Tutee) tutee).getEducationLevel().toString(), keyword)) == true;
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof EducationLevelContainsKeywordsPredicate // instanceof handles nulls
                && this.keywords.equals(((EducationLevelContainsKeywordsPredicate) other).keywords)); // state check
    }
}
