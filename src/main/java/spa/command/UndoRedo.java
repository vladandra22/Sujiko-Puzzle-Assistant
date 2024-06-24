package spa.command; // <<<<< TODO: Comment this line out when submitting to Momotor!

import java.util.Stack;

/**
 * TODO add javadoc.
 * @author vladandra22
 */
public class UndoRedo {

//# BEGIN TODO: Representation in terms of instance variables, incl. rep. inv.
    Stack<Command> canUndoStack = new Stack<>();
    Stack<Command> canRedoStack = new Stack<>();
//# END TODO

    /**
     * Returns whether an {@code undo} is possible.
     *
     * @return whether {@code undo} is possible
     */
    public boolean canUndo() {
//# BEGIN TODO: Implementation of canUndo
        if (canUndoStack.isEmpty()) {
            return false;
        }
        return true;
//# END TODO
    }

    /**
     * Returns whether a {@code redo} is possible.
     *
     * @return {@code redo().pre}
     */
    public boolean canRedo() {
//# BEGIN TODO: Implementation of canRedo
        if (canRedoStack.isEmpty()) {
            return false;
        }
        return true;
//# END TODO
    }

    /**
     * Returns command most recently done.
     *
     * @return command at top of undo stack
     * @throws IllegalStateException if precondition failed
     * @pre {@code canUndo()}
     */
    public Command lastDone() throws IllegalStateException {
//# BEGIN TODO: Implementation of lastDone
        if (!canUndo()) {
            throw new IllegalStateException("Undo not possible.");
        }
        return canUndoStack.peek();
//# END TODO
    }

    /**
     * Returns command most recently undone.
     *
     * @return command at top of redo stack
     * @throws IllegalStateException if precondition failed
     * @pre {@code canRedo()}
     */
    public Command lastUndone() throws IllegalStateException {
//# BEGIN TODO: Implementation of lastUndone
        if (!canRedo()) {
            throw new IllegalStateException("Redo not possible.");
        }
        return canRedoStack.peek();
//# END TODO
    }

    /**
     * Clears all undo-redo history.
     *
     * @modifies {@code this}
     */
    public void clear() {
//# BEGIN TODO: Implementation of clear
        canUndoStack.clear();
        canRedoStack.clear();
//# END TODO
    }

    /**
     * Adds given command to the do-history.
     * If the command was not yet executed, then it is first executed.
     *
     * @param command the command to incorporate
     * @modifies {@code this}
     */
    public void did(final Command command) {
//# BEGIN TODO: Implementation of did
        if  (!command.isExecuted()) {
            command.execute();
        }
        canUndoStack.push(command);
        canRedoStack.clear();
//# END TODO
    }

    /**
     * Undo the most recently done command, optionally allowing it to be redone.
     *
     * @param redoable whether to allow redo
     * @throws IllegalStateException if precondition violated
     * @pre {@code canUndo()}
     * @modifies {@code this}
     */
    public void undo(final boolean redoable) throws IllegalStateException {
//# BEGIN TODO: Implementation of undo
        if (!canUndo()) {
            throw new IllegalStateException("Undo not possible.");
        }
        Command command = canUndoStack.pop();
        command.revert();
        if (redoable) {
            canRedoStack.push(command);
        }
//# END TODO
    }

    /**
     * Redo the most recently undone command.
     *
     * @throws IllegalStateException if precondition violated
     * @pre {@code canRedo()}
     * @modifies {@code this}
     */
    public void redo() throws IllegalStateException {
//# BEGIN TODO: Implementation of redo
        if (!canRedo()) {
            throw new IllegalStateException("Redo not possible.");
        }
        Command command = canRedoStack.pop();
        command.execute();
        canUndoStack.push(command);
//# END TODO
    }

    /**
     * Undo all done commands.
     *
     * @param redoable whether to allow redo
     * @modifies {@code this}
     */
    public void undoAll(final boolean redoable) {
//# BEGIN TODO: Implementation of undoAll
        while (!canUndoStack.isEmpty()) {
            undo(redoable);
        }
//# END TODO
    }

    /**
     * Redo all undone commands.
     *
     * @modifies {@code this}
     */
    public void redoAll() {
//# BEGIN TODO: Implementation of redoAll
        while (!canRedoStack.isEmpty()) {
            redo();
        }
//# END TODO
    }

    /**
     * Returns canRedoStack.
     */
    public Stack<Command> getRedoStack() {
        return canRedoStack;
    }
    
    /**
     * Returns canUndoStack.
     */
    public Stack<Command> getUndoStack() {
        return canUndoStack;
    }
}
