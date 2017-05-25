package tree;

import list.Position;

public interface Tree<E> extends Iterable<E> {
	Position<E> root();

	Position<E> parent(Position<E> p) throws IllegalArgumentException;

	Iterable<Position<E>> children(Position<E> p)
			throws IllegalArgumentException;

	int numChildren(Position<E> p) throws IllegalArgumentException;

}
