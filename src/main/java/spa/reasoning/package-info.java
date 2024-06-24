/**
 * Package holding all classes for automatic reasoning.
 *
 * See the contract of {@link kpa.reasoning.Reasoner#apply()} for details
 * on how a reasoner works.
 * A reasoner is used by
 * <ul>
 * <li>constructing a new reasoner, and providing the puzzle it operates on,
 *      plus possibly another reasoner (in case of decorated reasoners);
 * </li>
 * <li>optionally combining it into other reasoners,
 *   using {@link kpa.reasoning.FixpointReasoner}, and/or
 *   {@link kpa.reasoning.CompoundReasoner} (via {@code add()});
 * <li>calling its {@link kpa.reasoning.Reasoner#apply()} method;</li>
 * <li>handling the returned result:
 *      <ul>
 *      <li>If {@code null} was returned, the reasoning led to a contradiction,
 *          indicating that the puzzle is not solvable from this state;
 *          the puzzle has not been modified</li>
 *      <li>If the returned {@link kpa.command.CompoundCommand} is empty,
 *          then reasoning did not result in any forced commands;
 *          the puzzle has not been modified</li>
 *      <li>If the returned {@link kpa.command.CompoundCommand} is non-empty,
 *          then reasoning led to the returned forced commands;
 *          these commands have been executed on the puzzle.</li>
 *      </ul></li>
 * </ul>
 *
 * <p>
 * New reasoners can be defined in various ways:
 * <ul>
 * <li>By inheriting from {@link kpa.reasoning.Reasoner} and overriding
 *   {@link kpa.reasoning.Reasoner#apply()}</li>
 * <li>By inheriting from {@link kpa.reasoning.EmptyCellReasoner} and overriding
 *   its hook method {@code applyToCell()}
 *   (Template Method pattern);
 *   {@link kpa.reasoning.EntryWithOneEmptyCell} is an example</li>
 * <li>By inheriting from {@link kpa.reasoning.ReasonerDecorator} and
 *   overriding {@link kpa.reasoning.Reasoner#apply()} using the decorated
 *   reasoner (Decorator pattern);
 *   {@link kpa.reasoning.FixpointReasoner} is an example</li>
 *
 * </ul>
 *
 */
package spa.reasoning;
