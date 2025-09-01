package br.com.dio.kanbanconsole.ui;

import br.com.dio.kanbanconsole.dto.CreateCardDto;
import br.com.dio.kanbanconsole.model.Board;
import br.com.dio.kanbanconsole.model.KanbanCard; // <-- MUDANÇA AQUI
import br.com.dio.kanbanconsole.service.BoardQueryService;
import br.com.dio.kanbanconsole.service.CardCommandService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Scanner;

@Profile("!test")
@Component
public class KanbanConsoleRunner implements CommandLineRunner {
    private final BoardQueryService boardQueryService;
    private final CardCommandService cardCommandService;
    private final Scanner scanner = new Scanner(System.in);

    public KanbanConsoleRunner(BoardQueryService boardQueryService, CardCommandService cardCommandService) {
        this.boardQueryService = boardQueryService;
        this.cardCommandService = cardCommandService;
    }

    // ... (os métodos run, printMenu permanecem iguais) ...

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- BEM-VINDO AO KANBAN CONSOLE ---");
        while (true) {
            printMenu();
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        displayAllBoards();
                        break;
                    case 2:
                        createCard();
                        break;
                    case 3:
                        moveCard();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1. Visualizar Quadros");
        System.out.println("2. Criar novo Card");
        System.out.println("3. Mover Card");
        System.out.println("0. Sair");
        System.out.print("> ");
    }

    private void displayAllBoards() {
        List<Board> boards = boardQueryService.findAllBoardsWithCards();
        System.out.println("\n--- QUADRO KANBAN ---");
        for (Board board : boards) {
            System.out.println("====================");
            System.out.printf("QUADRO: %s (ID: %d)\n", board.getName(), board.getId());
            System.out.println("--------------------");
            if (board.getCards() == null || board.getCards().isEmpty()) {
                System.out.println("(Vazio)");
            } else {
                for (KanbanCard card : board.getCards()) { // <-- MUDANÇA AQUI
                    System.out.printf("- Card ID: %d | Título: %s\n", card.getId(), card.getTitle());
                }
            }
        }
        System.out.println("====================");
    }

    private void createCard() {
        try {
            System.out.print("Digite o título do novo card: ");
            String title = scanner.nextLine();
            System.out.print("Digite o ID do quadro onde deseja criar o card: ");
            Long boardId = Long.parseLong(scanner.nextLine());
            CreateCardDto dto = new CreateCardDto();
            dto.setTitle(title);
            dto.setBoardId(boardId);
            KanbanCard card = cardCommandService.createCard(dto); // <-- MUDANÇA AQUI
            System.out.printf("Card '%s' criado com sucesso no quadro ID %d!\n", card.getTitle(), card.getBoard().getId());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void moveCard() {
        try {
            System.out.print("Digite o ID do card que deseja mover: ");
            Long cardId = Long.parseLong(scanner.nextLine());
            System.out.print("Digite o ID do quadro de destino: ");
            Long newBoardId = Long.parseLong(scanner.nextLine());
            KanbanCard card = cardCommandService.moveCard(cardId, newBoardId); // <-- MUDANÇA AQUI
            System.out.printf("Card ID %d movido com sucesso para o quadro '%s'!\n", card.getId(), card.getBoard().getName());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}